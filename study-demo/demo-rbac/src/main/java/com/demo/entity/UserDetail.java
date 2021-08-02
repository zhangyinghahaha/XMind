package com.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author ying.zhang01
 */
public class UserDetail extends User {
    private com.demo.entity.User user;

    public UserDetail(com.demo.entity.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(),authorities);
        this.user = user;
    }
}
