package pl.coderslab.crmproject.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.user.domain.User;
import pl.coderslab.crmproject.user.domain.UserRepository;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user){
        user.setUsername(user.getUsername());
        user.setFirstName(user.getFirstName());
        user.setSurname(user.getSurname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        user.setRole(user.getRole());
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveEditUser(User user, User baseUser) {
        baseUser.setUsername(user.getUsername());
        baseUser.setFirstName(user.getFirstName());
        baseUser.setSurname(user.getSurname());
        baseUser.setRole(user.getRole());
        userRepository.save(baseUser);
    }
}
