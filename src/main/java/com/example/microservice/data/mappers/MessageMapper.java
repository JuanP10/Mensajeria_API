package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.MessageDto;
import com.example.microservice.data.entities.Message;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MessageMapper {

    MessageDto messageToMessageDto (Message message);
    Message messageDtoToMessage (MessageDto messageDto);
}
