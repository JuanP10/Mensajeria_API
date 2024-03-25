package com.example.microservice.data.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class UserDto {
    private Long IdUser;
    private String email;
    private String name;
    private String lastName;
    private Integer age;
    private String password;
    private String resPassword;
    private Boolean enable;
    private String picture;
    private String rol;
    private LocalDateTime createAt;
}

