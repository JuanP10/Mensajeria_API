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
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    private String email;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    private String password;
    @Column(name = "res_password")
    private String resPassword;
    private Boolean enable;
    private String picture;
    private String rol;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @OneToMany(mappedBy = "user")
    private List<Suggestion> listSugestions;
    @OneToMany(mappedBy = "user")
    private List<Message> messages;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "list_games", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private List<Game> listGames = new ArrayList<>();
}