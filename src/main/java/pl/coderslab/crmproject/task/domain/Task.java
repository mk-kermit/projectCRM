package pl.coderslab.crmproject.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_title", length = 40)
    private String title;
    @Column(name = "task_description")
    private String description;
    @Column(name = "task_status")
    private Status status;
}
