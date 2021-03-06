package pl.coderslab.crmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.crmproject.domain.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);

    @Query(value = "SELECT * FROM tasks INNER JOIN users_tasks ON tasks.id = users_tasks.tasks_id WHERE users_tasks.user_id = ?1", nativeQuery = true)
    List<Task> findTasksByUserId(Long id);

    @Query(value = "UPDATE tasks set task_description = ?1 where task.id = ?2", nativeQuery = true)
    Task changeDescriptionByTaskId (String desc, Long id);
}
