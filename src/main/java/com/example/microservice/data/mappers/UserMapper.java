package com.example.microservice.data.mappers;

import com.example.microservice.data.dtos.UserDtoSave;
import com.example.microservice.data.dtos.UserDtoSend;
import com.example.microservice.data.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    @Mappings({
            @Mapping( target = "createAt", source = "createAt", dateFormat = "dd-MM-yyyy")

    })


    User userDtoSaveToUser(UserDtoSave userDtoSave);
    UserDtoSend userToUserDtoSend(User user);



    List<UserDtoSend> toDtoSendList(List<User> users);




    User updateUserFromDtoSave(@MappingTarget User user, UserDtoSave userDtoSave);

}
