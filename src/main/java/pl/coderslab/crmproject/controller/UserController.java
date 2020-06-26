package pl.coderslab.crmproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crmproject.service.TaskService;
import pl.coderslab.crmproject.domain.User;
import pl.coderslab.crmproject.service.UserService;

@Builder
@AllArgsConstructor
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/loged")
public class UserController {
    final UserService userService;
    final TaskService taskService;

    @GetMapping("")
    public String home() {
        return "loged/homeUser";
    }


    @GetMapping("/myTasks")
    public String showMyTasks(User user, Model model) {
        model.addAttribute("myTasks", taskService.findForUserId(user.getId()));
        return "loged/myTasks";
    }

    @GetMapping("/change-status/{id}")
    public String changeStatus(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "loged/change-status";
    }
}
