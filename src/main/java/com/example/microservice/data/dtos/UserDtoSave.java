package com.example.microservice.data.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDtoSave {
    private Long idUser;
    private String email;
    private String name;
    private String lastName;
    private Integer age;
    private Boolean enable;
    private String picture;
    private String rol;
    private String password;
    private String resPassword;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createAt;

}
