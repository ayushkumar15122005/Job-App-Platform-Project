package com.ayush.JobApp.Controller;

import com.ayush.JobApp.Model.User;
import com.ayush.JobApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    // Endpoint for new users to create an account
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // Endpoint for existing users to get a JWT token
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.verify(user);
    }
}