package pl.coderslab.crmproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.domain.Task;
import pl.coderslab.crmproject.domain.User;
import pl.coderslab.crmproject.security.CurrentUser;
import pl.coderslab.crmproject.service.TaskService;
import pl.coderslab.crmproject.service.UserService;
import pl.coderslab.crmproject.util.validation.AddValidator;
import pl.coderslab.crmproject.util.validation.EditDescriptionValidator;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("baseTask")
@RequestMapping("/leader")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaderController {
    final UserService userService;
    final TaskService taskService;

    @ModelAttribute("userList")
    public List<User> getUsers() {
        return new ArrayList<>(userService.getEnableUsers());
    }

    @GetMapping("")
    public String leaderHome() {
        return "leader/homeLeader";
    }

    @GetMapping("/allTasks")
    public String showAllTasks(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "leader/allTasks";
    }

    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("userList", getUsers());
        return "leader/create-task";
    }

    @PostMapping("/create-task")
    public String processTaskForm(@ModelAttribute @Validated({Default.class, AddValidator.class})
                                          Task task,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "leader/create-task";
        }
        taskService.saveTask(task);
        return "redirect:/leader/allTasks";
    }

    @GetMapping("/edit-task/{id}")
    public String showEditTaskForm(Model model, @PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("baseTask", task);
        return "leader/edit-task";
    }

    @PostMapping("/edit-task/{id}")
    public String processUpdateTaskDescription(@Validated({Default.class, EditDescriptionValidator.class})
                                                       Task task,
                                               BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "leader/edit-task";
        }
        Task baseTask = (Task) session.getAttribute("baseTask");
        taskService.saveEditTask(task, baseTask);
        return "redirect:/leader/allTasks";
    }

    @GetMapping("/delete-task/{id}")
    public String showDelete(@PathVariable long id) {
        Task task = taskService.getTaskById(id);
        taskService.deleteTask(task);
        return "redirect:/leader/allTasks";
    }
}
