package pl.coderslab.crmproject.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.task.domain.Task;
import pl.coderslab.crmproject.task.domain.TaskRepository;
import pl.coderslab.crmproject.user.domain.UserRepository;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService{
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public Task findTaskByTitle(String title) {
        return taskRepository.findByTaskTitle(title);
    }

    @Override
    public void saveTask(Task task) {
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setStatus(task.getStatus());
        taskRepository.save(task);
    }
}
