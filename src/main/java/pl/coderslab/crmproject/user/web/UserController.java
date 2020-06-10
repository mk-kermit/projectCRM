package pl.coderslab.crmproject.user.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.coderslab.crmproject.user.service.UserService;

@AllArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

}
