package pl.coderslab.crmproject.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.crmproject.role.Role;
import pl.coderslab.crmproject.role.RoleRepository;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.domain.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
