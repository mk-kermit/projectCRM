package pl.coderslab.crmproject.user.service;

import pl.coderslab.crmproject.user.domain.User;

import java.util.Optional;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
