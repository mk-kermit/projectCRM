package pl.coderslab.crmproject.task.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.validation.AddValidator;
import pl.coderslab.crmproject.validation.EditValidator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_title", length = 40)
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String title;
    @Column(name = "task_description")
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String description;
    @Column(name = "task_status", length=20)
    private String status;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private User user;
    @Transient
    private List<User> userList;
}
