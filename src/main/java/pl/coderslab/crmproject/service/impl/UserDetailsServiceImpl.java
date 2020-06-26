package pl.coderslab.crmproject.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.crmproject.domain.User;
import pl.coderslab.crmproject.security.CurrentUser;
import pl.coderslab.crmproject.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    UserService userService;

    @Autowired
    public void setUserRepository(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new CurrentUser(user.getUsername(), user.getPassword(), grantedAuthorities, user);
    }
}
