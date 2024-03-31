package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameAndLastName(String name, String lastName);
    User findByEmail(String email);

    boolean existsByEmail(String email);

}
