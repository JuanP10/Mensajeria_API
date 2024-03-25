package com.example.microservice.data.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class MessageDtoSave {
    private Long id;
    private LocalDateTime createAt;
    private String content;
}
