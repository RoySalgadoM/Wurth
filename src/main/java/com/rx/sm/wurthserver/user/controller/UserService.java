package com.rx.sm.wurthserver.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    public void enc(){
        System.out.println(passwordEncoder.encode("roy"));
    }
}
