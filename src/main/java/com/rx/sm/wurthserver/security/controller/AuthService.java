package com.rx.sm.wurthserver.security.controller;

import com.rx.sm.wurthserver.security.model.AuthUser;
import com.rx.sm.wurthserver.user.model.User;
import com.rx.sm.wurthserver.user.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).get();
        return AuthUser.build(user);
    }

}

