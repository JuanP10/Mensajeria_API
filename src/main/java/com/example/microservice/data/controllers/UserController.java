package com.example.microservice.data.controllers;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private  final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserDtoSend createUser(@RequestBody UserDtoSave userDtoSave) {
        return userService.createUser(userDtoSave);
    }

    @GetMapping("/{userId}")
    public UserDtoSend getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/name&lastName")
    public List<UserDtoSend> getUsersByNameAndLastName(@RequestParam String name, @RequestParam String lastName) {
        return userService.getUsersByNameAndLastName(name, lastName);
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }


    @GetMapping("/all")
    public ResponseEntity<User> getAll() {
        return ResponseEntity.ok().body((User) this.userService.getAllUsers());
    }


    @DeleteMapping
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }
}
