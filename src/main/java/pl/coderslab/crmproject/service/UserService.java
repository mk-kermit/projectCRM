package pl.coderslab.crmproject.service;

import pl.coderslab.crmproject.domain.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);
    User findById(long id);
    void saveUser(User user);
    void saveEditUser(User user, User baseUser);
    void deleteUser(User user);
    List<User> getEnableUsers();
}
