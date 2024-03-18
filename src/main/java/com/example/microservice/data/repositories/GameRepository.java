package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
