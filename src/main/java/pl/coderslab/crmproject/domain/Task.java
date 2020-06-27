package pl.coderslab.crmproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.crmproject.util.validation.AddValidator;
import pl.coderslab.crmproject.util.validation.EditTitleValidator;
import pl.coderslab.crmproject.util.validation.EditValidator;

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
    @NotNull(groups = {AddValidator.class, EditTitleValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditTitleValidator.class})
    private String title;

    @Column(name = "task_description")
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String description;

    @Column(name = "task_status", length = 20)
    private String status;

    @Transient
    private List<User> userList;
}
