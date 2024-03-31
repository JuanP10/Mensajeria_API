package com.example.microservice.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mensajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idMessage;
    private String creator;
    private String destinatary;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    private String content;
    @ManyToOne @JoinColumn(name = "idUser")
    private User user;

}
