package pl.coderslab.crmproject.login;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.crmproject.user.domain.CurrentUser;
import pl.coderslab.crmproject.user.domain.User;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSuccess(Model model, HttpSession session) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = ((CurrentUser) authenticationToken.getPrincipal()).getUser();

        model.addAttribute("currentUserId", loggedUser.getId());
        model.addAttribute("currentUser", loggedUser.getUsername());
        session.setAttribute("userId", loggedUser.getId());
        return "redirect:/loged/";
    }

}
