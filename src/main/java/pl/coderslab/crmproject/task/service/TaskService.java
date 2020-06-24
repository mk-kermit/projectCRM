package pl.coderslab.crmproject.task.service;

import pl.coderslab.crmproject.task.domain.Task;

import java.util.List;

public interface TaskService {
    Task findTaskByTitle(String title);
    List<Task> findForUserId(Long id);
    void saveTask(Task task);
}
