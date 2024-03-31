package com.example.microservice.data.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class UserDtoSend {
    private Long idUser;
    private String email;
    private String name;
    private String lastName;
    private Integer age;
    private Boolean enable;
    private String picture;
    private String rol;
    private LocalDateTime createAt;
}

