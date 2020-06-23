package pl.coderslab.crmproject.login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crmproject.task.domain.TaskRepository;
import pl.coderslab.crmproject.user.domain.CurrentUser;
import pl.coderslab.crmproject.user.domain.UserRepository;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/loged")
public class LogedController {

    private UserRepository userRepository;
    private TaskRepository taskRepository;
    @GetMapping("")
    public String home(){
        return "loged/homeUser";
    }

    @GetMapping("/mainboard")
    public String mainBoard(){
        return "loged/mainboard";
    }

    @GetMapping("/myTasks/")
    public String showMyTasks(CurrentUser currentUser, Model model){
        model.addAttribute("myTasks", taskRepository.findTaskByUserId(currentUser.getUser().getId()));
        return "loged/myTasks";
    }
}
