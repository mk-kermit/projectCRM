package pl.coderslab.crmproject.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loged")
public class MainBoardController {

    @GetMapping("/mainboard")
    public String showMainboard(){
        return "loged/mainboard";
    }
}
