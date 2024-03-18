package com.example.microservice.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partidos")
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
    private LocalDateTime date;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    private Integer participants;
    private Integer subs;
    private String coments;
    @ManyToMany(mappedBy = "listGames")
    private List<User> users = new ArrayList<>();
}