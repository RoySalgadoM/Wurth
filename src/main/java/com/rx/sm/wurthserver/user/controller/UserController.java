package com.rx.sm.wurthserver.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/")
    public void enc(){
        service.enc();
    }
}
