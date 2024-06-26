package com.example.microservice.data.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "juegos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;
    private String creator;
    private String sport;
    private String city;
    private String province;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    private Integer participants;
    private Integer subs;
    private String coments;
    @ManyToMany(mappedBy = "listGames")
    private List<User> users = new ArrayList<>();
}