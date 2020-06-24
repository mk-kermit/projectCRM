package pl.coderslab.crmproject.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.crmproject.task.domain.Task;

import javax.persistence.*;
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
    @Column(name = "user_name", unique = true, length = 60, nullable = false)
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_first_name", length = 60)
    private String firstName;
    @Column(name = "user_surname", length = 80)
    private String surname;
    @Column(name = "user_enabled", length = 1)
    private int enabled;
    @Column(name = "user_role")
    private Role role;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Task> tasks;
}
