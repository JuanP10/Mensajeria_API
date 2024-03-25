package com.example.microservice.data.services;

import com.example.microservice.data.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllByNameAndLastName (String name, String lastName);
    List<User> findByEmail(String email);
    List<User> getAll();

    public User getUserById(Long id);
    public User createUser(User user);
}
