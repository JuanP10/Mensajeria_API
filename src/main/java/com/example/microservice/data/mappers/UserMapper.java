package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    @Mappings({
            @Mapping( target = "createAt", source = "createAt", dateFormat = "dd-MM-yyyy")

    })

    UserDtoSend toDtoSend(User user);

    List<UserDtoSend> toDtoSendList(List<User> users);

    @Mappings({
            @Mapping(target = "createAt", source = "createAt", dateFormat = "dd-MM-yyyy"),
            // Otros mapeos si es necesario
    })
    User toEntity(UserDtoSave userDtoSave);

    UserDtoSave toDtoSave(User user);

    List<UserDtoSave> toDtoSaveList(List<User> users);


    User toEntity(UserDtoSend userDtoSend);
}
