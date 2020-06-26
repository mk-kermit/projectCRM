package pl.coderslab.crmproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crmproject.domain.Task;
import pl.coderslab.crmproject.domain.User;
import pl.coderslab.crmproject.security.CurrentUser;
import pl.coderslab.crmproject.service.TaskService;
import pl.coderslab.crmproject.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/leader")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaderController {
    final UserService userService;
    final TaskService taskService;

    @ModelAttribute("userList")
    public List<User> getUsers(){
        return new ArrayList<>(userService.getEnableUsers());
    }
    @GetMapping("")
    public String leaderHome() {
        return "leader/homeLeader";
    }

    @GetMapping("/allTasks")
    public String showAllTasks(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("taskList", taskService.getAllTasks());
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
        taskService.saveTask(task);
        return "redirect:/leader/allTasks";
    }

    @GetMapping("/edit-task/{id}")
    public String showEditTaskForm(Model model, @PathVariable long id) {
        Task editTask = taskService.getTaskById(id);
        model.addAttribute("task", editTask);
        return "leader/edit-task";
    }

    @PostMapping("/edit-task/{id}")
    public String processUpdateTaskDescription(@PathVariable long id, @ModelAttribute(name = "task") @Validated Task task,
                                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "leader/edit-task";
        }
        taskService.updateDescription(task, task.getDescription());
        taskService.saveTask(task);
        return "redirect:../../leader/allTasks";
    }

    @GetMapping("/delete-task/{id}")
    public String showDelete(@PathVariable long id){
        Task task = taskService.getTaskById(id);
        taskService.deleteTask(task);
        return "redirect:../../leader/allTasks";
    }
}
