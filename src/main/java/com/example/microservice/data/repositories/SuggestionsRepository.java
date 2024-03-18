package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionsRepository extends JpaRepository<Suggestion, Long> {

}
