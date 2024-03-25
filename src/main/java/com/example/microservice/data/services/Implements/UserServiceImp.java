package com.example.microservice.data.services.Implements;

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
    public List<User> findAllByNameAndLastName(String name, String lastName) {
        return this.userRepository.findByNameAndlastName(name, lastName);
    }

    @Override
    public List<User> findByEmail(String email) {
        return (List<User>) this.userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User User = this.userRepository.getById(id);
        return User;
    }
}
