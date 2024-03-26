package com.example.microservice.data.services;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    UserDtoSend createUser(UserDtoSend userDtoSend);
    List<UserDtoSend> getAllUsersToSend();


    UserDtoSend createUser(UserDtoSave userDtoSave);
    List<UserDtoSave> getAllUsersToSave();

    void deleteUser(Long userId);
}
