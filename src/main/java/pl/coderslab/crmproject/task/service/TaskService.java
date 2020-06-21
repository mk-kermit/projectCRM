package pl.coderslab.crmproject.task.service;

import pl.coderslab.crmproject.task.domain.Task;

public interface TaskService {
    Task findTaskByTitle(String title);
    void saveTask(Task task);
}
