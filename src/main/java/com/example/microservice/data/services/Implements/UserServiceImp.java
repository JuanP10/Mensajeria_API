package com.example.microservice.data.services.Implements;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import com.example.microservice.data.mappers.UserMapper;
import com.example.microservice.data.repositories.UserRepository;
import com.example.microservice.data.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDtoSend createUser(UserDtoSave userDtoSave) {
        User user = userMapper.toEntity(userDtoSave);
        user = userRepository.save(user);
        return userMapper.toDtoSend(user);
    }

    @Override
    public List<UserDtoSend> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoSendList(users);
    }


    @Override
    public UserDtoSend getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        return userMapper.toDtoSend(user);
    }

    @Override
    public List<UserDtoSend> getUsersByNameAndLastName(String name, String lastName) {
        List<User> users = userRepository.findByNameAndLastName(name, lastName);
        return userMapper.toDtoSendList(users);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
