package pl.coderslab.crmproject.leader.web;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.task.domain.Task;
import pl.coderslab.crmproject.task.domain.TaskRepository;
import pl.coderslab.crmproject.user.domain.CurrentUser;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/leader")
public class LeaderController {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @ModelAttribute("userList")
    public List<User> getUsers(){
        return new ArrayList<>(userRepository.findAllByEnabled(1));
    }
    @GetMapping("")
    public String leaderHome() {
        return "leader/homeLeader";
    }

    @GetMapping("/allTasks")
    public String showAllTasks(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("taskList", taskRepository.findAll());
        return "leader/allTasks";
    }

    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("userList", getUsers());
        return "leader/create-task";
    }

    @PostMapping("/create-task")
    public String processTaskForm(@ModelAttribute @Validated Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "leader/create-task";
        }
        taskRepository.save(task);
        return "redirect:/leader/allTasks";
    }

    @GetMapping("/edit-task/{id}")
    public String showEditTaskForm(Model model, @PathVariable long id) {
        Task task = taskRepository.findById(id);
        model.addAttribute("task", task);
        return "leader/edit-task";
    }

    @PostMapping("/edit-task/{id}")
    public String processUpdateTaskForm(@PathVariable long id, @ModelAttribute @Validated Task task,
                                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "leader/edit-task";
        }

        task.setDescription(taskRepository.findById(id).getDescription());
        taskRepository.save(task);
        return "redirect:../../leader/allTasks";
    }

    @GetMapping("/delete-task/{id}")
    public String showDelete(Model model, @PathVariable long id){
        return "deleteQuestion";
    }
}
