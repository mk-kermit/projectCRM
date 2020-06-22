package pl.coderslab.crmproject.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loged")
public class LogedController {
    @GetMapping("")
    public String home(){
        return "loged/home";
    }

    @GetMapping("/mainboard")
    public String mainBoard(){
        return "loged/mainboard";
    }
}
