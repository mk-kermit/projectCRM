package pl.coderslab.crmproject.domain;

import lombok.*;
import pl.coderslab.crmproject.util.validation.AddValidator;
import pl.coderslab.crmproject.util.validation.EditPasswordValidator;
import pl.coderslab.crmproject.util.validation.EditValidator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, length = 60)
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String username;

    @Column(name = "user_password", length = 60)
    @NotNull(groups = {AddValidator.class, EditPasswordValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditPasswordValidator.class})
    private String password;

    @Column(name = "user_first_name", length = 60)
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String firstName;

    @Column(name = "user_surname", length = 80)
    @NotNull(groups = {AddValidator.class, EditValidator.class})
    @NotEmpty(groups = {AddValidator.class, EditValidator.class})
    private String surname;

    @Column(name = "user_enabled", length = 1)
    private int enabled;

    @Column(name = "user_role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Task> tasks;
}
