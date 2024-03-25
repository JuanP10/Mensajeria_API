package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("/all")
    public ResponseEntity<User> getAll() {
        return ResponseEntity.ok().body((User) this.userService.getAll());
    }
}
