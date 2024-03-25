package com.example.microservice.data.controllers;

import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private  final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
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
