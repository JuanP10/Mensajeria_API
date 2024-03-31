package com.example.microservice.data.controllers;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.services.UserService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<UserDtoSend> createUser(@RequestBody UserDtoSave userDtoSave) {
        UserDtoSend createdUser = userService.createUser(userDtoSave);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDtoSend> updateUser(@PathVariable Long userId, @RequestBody UserDtoSave userDtoSave) {
        UserDtoSend updatedUser = userService.updateUserById(userId, userDtoSave);
        return ResponseEntity.ok(updatedUser);
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
    public ResponseEntity<List<UserDtoSend>> getAllUsers() {
        List<UserDtoSend> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
