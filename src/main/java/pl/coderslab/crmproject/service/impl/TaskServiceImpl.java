package pl.coderslab.crmproject.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.domain.Task;
import pl.coderslab.crmproject.repository.TaskRepository;
import pl.coderslab.crmproject.repository.UserRepository;
import pl.coderslab.crmproject.service.TaskService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

import static pl.coderslab.crmproject.enumeration.Status.STATUS_OPEN;


@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TaskServiceImpl implements TaskService {
    final UserRepository userRepository;
    final TaskRepository taskRepository;

    @Override
    public Task findTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public void saveTask(Task task) {
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setStatus(STATUS_OPEN.toString());
        taskRepository.save(task);
        log.info("Task with id {} has been saved", task.getId());
    }

    @Override
    public List<Task> findTasksByUserId(Long id) {
        return taskRepository.findTasksByUserId(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateDescription(Task task, String description){
        task.setDescription(description);
        taskRepository.save(task);
        log.info("Description has been updated");
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
        log.info("Task with id {} has been deleted", task.getId());
    }

    @Override
    public void changeTaskStatus(Task task, String status) {
        task.setStatus(status);
        taskRepository.save(task);
        log.info("Task with id {} has changed his status", task.getId());
    }
}
