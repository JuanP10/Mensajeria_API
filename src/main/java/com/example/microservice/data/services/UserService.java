package com.example.microservice.data.services;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;

import java.util.List;

public interface UserService {

    UserDtoSend createUser(UserDtoSave userDtoSave); //

    List<UserDtoSend> getAllUsers();
    UserDtoSend updateUserById(Long userId, UserDtoSave userDtoSave);


    UserDtoSend getUserById(Long userId);


    void deleteUser(Long userId);

    List<UserDtoSend> getUsersByNameAndLastName(String name, String lastName);

    User getUserByEmail(String email);
}
