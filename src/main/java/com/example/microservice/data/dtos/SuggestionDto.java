package com.example.microservice.data.dtos;

import com.example.microservice.data.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class SuggestionDto {
    private Long id;
    private String description;
    private LocalDateTime createAt;
}
