package com.example.microservice.data.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class MessageDto {
    private Long idMessage;
    private String creator;
    private String destinatary;
    private LocalDateTime createAt;
    private String content;
}
