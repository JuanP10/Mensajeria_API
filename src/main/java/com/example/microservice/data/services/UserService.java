package com.example.microservice.data.services;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;

import java.util.List;

public interface UserService {

    List<UserDtoSend> getAllUsers();
    UserDtoSend getUserById(Long userId);

    List<UserDtoSend> getUsersByNameAndLastName(String name, String lastName);

    UserDtoSend createUser(UserDtoSave userDtoSave);

    User getUserByEmail(String email);

    void deleteUser(Long userId);
}
