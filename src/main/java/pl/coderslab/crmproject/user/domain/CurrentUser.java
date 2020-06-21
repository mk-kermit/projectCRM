package pl.coderslab.crmproject.user.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private final pl.coderslab.crmproject.user.domain.User user;
    public CurrentUser (String username, String password, Collection<? extends GrantedAuthority> authorities, pl.coderslab.crmproject.user.domain.User user){
        super(username, password, authorities);
        this.user = user;
    }
    public pl.coderslab.crmproject.user.domain.User getUser(){
        return user;
    }
}
