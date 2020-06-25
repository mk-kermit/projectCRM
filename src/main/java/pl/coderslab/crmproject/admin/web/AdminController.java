package pl.coderslab.crmproject.admin.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.user.domain.Role;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.domain.UserRepository;
import pl.coderslab.crmproject.user.service.UserService;
import pl.coderslab.crmproject.validation.AddValidator;
import pl.coderslab.crmproject.validation.EditValidator;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;
import java.util.Arrays;
import java.util.List;

@Builder
@AllArgsConstructor
@Controller
@SessionAttributes({"baseUser"})
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private UserRepository userRepository;

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.ROLE_USER, Role.ROLE_LEADER);
    }

    @GetMapping("")
    public String showHome() {
        return "admin/homeAdmin";
    }

    @GetMapping("/userList")
    public String showAllUsers(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "admin/userList";
    }

    @GetMapping("/create-user")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/create-user";
    }

    @PostMapping("/create-user")
    public String processCreateUserForm(@Validated({Default.class, AddValidator.class}) User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-user";
        }
        user.setEnabled(1);
        userRepository.save(user);
        return "redirect:/admin/userList";
    }

    @GetMapping("/edit-user/{id}")
    public String showUserEditionForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("baseUser", user);
        return "admin/edit-user";
    }

    @PostMapping("/edit-user/{id}")
    public String processUserEditionForm(@Validated({Default.class, EditValidator.class}) User user,
                                         BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "admin/edit-user";
        }
        User baseUser = (User) session.getAttribute("baseUser");
        userService.saveEditUser(user, baseUser);
        return "redirect:../../admin/userList";
    }
}
