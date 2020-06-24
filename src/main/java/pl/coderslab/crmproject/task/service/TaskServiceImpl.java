package pl.coderslab.crmproject.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.task.domain.Status;
import pl.coderslab.crmproject.task.domain.Task;
import pl.coderslab.crmproject.task.domain.TaskRepository;
import pl.coderslab.crmproject.user.domain.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService{
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public Task findTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public void saveTask(Task task) {
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setStatus(Status.STATUS_OPEN);
        taskRepository.save(task);
    }

    @Override
    public List<Task> findForUserId(Long id) {
        List<Task> myTasks = taskRepository.findTasksByUserId(id);
        return myTasks;
    }
}
