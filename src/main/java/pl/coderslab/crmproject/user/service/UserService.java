package pl.coderslab.crmproject.user.service;

import pl.coderslab.crmproject.user.domain.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    User findById(long id);
}
