package pl.coderslab.crmproject.task.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);
    Task findById(long id);
    @Query(value = "SELECT * FROM tasks INNER JOIN users_tasks on tasks.id = users_tasks.user_id WHERE users_tasks.user_id = ?1", nativeQuery = true)
    List<Task> findTasksByUserId(Long id);
}
