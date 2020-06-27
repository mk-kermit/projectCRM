package pl.coderslab.crmproject.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.domain.Task;
import pl.coderslab.crmproject.enumeration.Status;
import pl.coderslab.crmproject.security.CurrentUser;
import pl.coderslab.crmproject.service.TaskService;
import pl.coderslab.crmproject.service.UserService;
import pl.coderslab.crmproject.util.validation.EditValidator;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
@SessionAttributes("baseTask")
@RequestMapping("/loged")
public class UserController {
    final UserService userService;
    final TaskService taskService;
    CurrentUser currentUser;

    @ModelAttribute("statuses")
    public List<Status> getStatuses() {
        return Arrays.asList(Status.STATUS_IN_PROGRESS, Status.STATUS_DONE);
    }

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        this.currentUser = currentUser;
        return currentUser;
    }

    @GetMapping("")
    public String home() {
        return "loged/homeUser";
    }


    @GetMapping("/myTasks")
    public String showMyTasks(Model model) {
        model.addAttribute("myTasks", taskService.findTasksByUserId(currentUser.getUser().getId()));
        return "loged/myTasks";
    }

    @GetMapping("/change-status/{id}")
    public String changeStatusForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("baseTask", task);
        return "loged/change-status";
    }

    @PostMapping("/change-status/{id}")
    public String processChangeStatusForm(@ModelAttribute @Validated({EditValidator.class})
                                                      Task task, Model model,
                                          BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return "loged/myTasks";
        }
        Task baseTask = (Task) session.getAttribute("baseTask");
        taskService.changeTaskStatus(task, baseTask);
        model.addAttribute("myTasks", taskService.findTasksByUserId(currentUser.getUser().getId()));
        return "redirect:/loged/myTasks";
    }
}
