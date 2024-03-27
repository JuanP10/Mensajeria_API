package com.example.microservice.data.repositories;

import com.example.microservice.data.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>{

    @Query("SELECT m FROM Message m WHERE m.user.IdUser = :userId")
    List<Message> findAllByUserId(@Param("userId") Long userId);

    List<Message> findAllByCreator (String creator);

    List<Message> findAllByDestinatary (String destinatary);

    List<Message> findAllByCreatorAndDestinatary (String creator, String destinatary);

}
