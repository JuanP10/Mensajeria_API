package com.example.microservice.data.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class GameDto {
    private Long idGame;
    private String creator;
    private String sport;
    private String city;
    private String province;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private Integer participants;
    private Integer subs;
    private String coments;
}
