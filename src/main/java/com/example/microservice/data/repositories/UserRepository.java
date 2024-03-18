package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameAndlastName(String name, String lastName);
    User findByEmail(String email);
}
