package com.example.microservice.data.services.Implements;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.mappers.UserMapper;
import com.example.microservice.data.repositories.UserRepository;
import com.example.microservice.data.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDtoSend createUser(UserDtoSend userDtoSend) {
        User user = userMapper.toEntity(userDtoSend);
        user = userRepository.save(user);
        return userMapper.toDtoSend(user);
    }


    @Override
    public UserDtoSend createUser(UserDtoSave userDtoSave) {
        User user = userMapper.toEntity(userDtoSave);
        user = userRepository.save(user);
        return userMapper.toDtoSend(user);
    }

    @Override
    public List<UserDtoSend> getAllUsersToSend() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoSendList(users);
    }

    @Override
    public List<UserDtoSave> getAllUsersToSave() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoSaveList(users);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
