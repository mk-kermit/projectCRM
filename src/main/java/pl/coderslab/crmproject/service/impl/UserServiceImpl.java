package pl.coderslab.crmproject.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.domain.User;
import pl.coderslab.crmproject.repository.UserRepository;
import pl.coderslab.crmproject.service.UserService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final BCryptPasswordEncoder passwordEncoder;

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
        log.info("User with id {} has been saved", user.getId());
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveEditUser(User user, User baseUser) {
        user.setUsername(baseUser.getUsername());
        user.setFirstName(baseUser.getFirstName());
        user.setSurname(baseUser.getSurname());
        user.setRole(baseUser.getRole());
        userRepository.save(user);
        log.info("User with id {} has been saved", user.getId());
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getEnableUsers() {
        return userRepository.findAllByEnabled(1);
    }
}
