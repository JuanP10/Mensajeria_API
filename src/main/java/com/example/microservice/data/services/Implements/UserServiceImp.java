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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDtoSend createUser(UserDtoSave userDtoSave) {
        User user = userMapper.userDtoSaveToUser(userDtoSave);
        user.setCreateAt(LocalDateTime.now()); // establecer la fecha de creación
        if (userRepository.existsByEmail(userDtoSave.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDtoSend(savedUser);
    }

    @Override
    public List<UserDtoSend> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDtoSend)
                .collect(Collectors.toList());
    }


    @Override
    public UserDtoSend getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        return userMapper.userToUserDtoSend(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDtoSend> getUsersByNameAndLastName(String name, String lastName) {
        return userMapper.toDtoSendList(userRepository.findByNameAndLastName(name, lastName));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDtoSend updateUserById(Long userId, UserDtoSave userDtoSave) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado por el ID : " + userId));
        existingUser = userMapper.updateUserFromDtoSave(existingUser, userDtoSave);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.userToUserDtoSend(updatedUser);
    }
}
