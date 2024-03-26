package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findAllByIdUser(Long idUser);

    List<Message> findAllByCreator (String creator);

    List<Message> findAllByDestinatary (String destinatary);

    List<Message> findAllByCreatorAndDestinatary (String creator, String destinatary);

}
