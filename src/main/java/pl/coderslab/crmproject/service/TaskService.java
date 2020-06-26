package pl.coderslab.crmproject.service;

import pl.coderslab.crmproject.domain.Task;

import java.util.List;

public interface TaskService {
    Task findTaskByTitle(String title);

    List<Task> findForUserId(Long id);

    void saveTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void updateDescription(Task task, String description);

    void deleteTask(Task task);
}
