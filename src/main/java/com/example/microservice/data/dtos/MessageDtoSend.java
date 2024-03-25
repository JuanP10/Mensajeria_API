package com.example.microservice.data.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDtoSend {
    private Long id;
    private UserDtoSend emisor;
    private UserDtoSend receptor;
    private LocalDateTime createAt;
    private String content;
}
