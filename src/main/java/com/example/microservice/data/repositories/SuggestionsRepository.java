package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Suggestion;
import com.example.microservice.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SuggestionsRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findAllById(Long id);
}
