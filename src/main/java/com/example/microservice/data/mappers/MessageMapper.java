package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.MessageDtoSave;
import com.example.microservice.data.entities.Message;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MessageMapper {

    MessageDtoSave messageToMessageDto (Message message);
    Message messageDtoToMessage (MessageDtoSave messageDto);
}
