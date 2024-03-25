package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Override
    Optional<Game> findById(Long along);

    Optional<Game> findByName(String name);

}
