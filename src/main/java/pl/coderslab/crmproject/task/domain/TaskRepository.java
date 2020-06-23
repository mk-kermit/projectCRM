package pl.coderslab.crmproject.task.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);
    Task findById(long id);
    List<Task> findTaskByUserId(long id);

}
