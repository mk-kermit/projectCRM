package pl.coderslab.crmproject.admin.web;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crmproject.role.RoleRepository;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.service.UserService;

@Builder
@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleRepository roleRepository;

    @GetMapping("/create-user")
    public String showCreateUserForm(Model model){
        model.addAttribute("user", new User());
        return "admin/create-user";
    }

    @PostMapping("/create-user")
    public String showNewUserDetails(@ModelAttribute(name = "user") @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create-user";
        }
        User optionalUser = userService.findByUserName(user.getUsername());

        return "userList";
    }
}
