package pl.coderslab.crmproject.leader.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crmproject.task.domain.Task;
import pl.coderslab.crmproject.task.domain.TaskRepository;
import pl.coderslab.crmproject.user.domain.UserRepository;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/leader")
public class LeaderController {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @GetMapping("")
    public String leaderHome(){
        return "leader/home";
    }

    @GetMapping("/mainboard")
    public String leaderMainboard(){
        return "leader/mainboard";
    }

    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "leader/create-task";
    }

    @PostMapping("/create-task")
    public String processTaskForm(@ModelAttribute @Validated Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "leader/create-task";
        }
        return "leader/mainboard";
    }

}
