package pl.coderslab.crmproject.service;

import pl.coderslab.crmproject.domain.Task;

import java.util.List;

public interface TaskService {
    Task findTaskByTitle(String title);

    List<Task> findTasksByUserId(Long id);

    void saveTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void saveEditTask(Task task, Task baseTask);

    void changeDescription(Task task, String description);

    void deleteTask(Task task);

    void changeTaskStatus(Task task, Task baseTask);
}
