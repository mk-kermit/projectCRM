package pl.coderslab.crmproject.admin.web;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.role.RoleRepository;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.domain.UserRepository;
import pl.coderslab.crmproject.user.service.UserService;

@Builder
@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @GetMapping("/create-user")
    public String showCreateUserForm(Model model){
        model.addAttribute("user", new User());
        return "admin/create-user";
    }

    @PostMapping("/create-user")
    public String processCreateUserForm(@ModelAttribute(name = "user") @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create-user";
        }
        User newUser = userService.findByUserName(user.getUsername());
        userRepository.save(newUser);
        return "userList";
    }

    @GetMapping("/edit-user/{id}")
    public String showUserEditionForm(@PathVariable Long id, Model model){
        User user = userService.findByUserId(id);
        model.addAttribute("user", user);
        return "/admin/edit-user";
    }
    @PostMapping("/edit-user/{id}")
    public String processUserEditionForm(@ModelAttribute(name = "user") @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/admin/edit-user";
        }
        userRepository.save(user);
        return "redirect:../../userList";
    }
}
