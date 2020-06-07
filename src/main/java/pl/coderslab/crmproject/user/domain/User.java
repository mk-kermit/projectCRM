package pl.coderslab.crmproject.user.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.crmproject.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name", unique = true)
    @Length(min = 5, max = 60, message = "Login musi mieć przynajmniej 5 znaków")
    @NotEmpty
    private String username;
    @Column(name = "user_password")
    @Length(min = 5, message = "Hasło musi posiadać przynajmniej 5 znaków")
    @NotEmpty
    private String password;
    @Column(name = "user_enabled")
    @Length(max = 1)
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
