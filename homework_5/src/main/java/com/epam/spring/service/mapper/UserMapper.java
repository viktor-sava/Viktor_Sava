package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto mapModelToDto(User user);

    User mapDtoToModel(UserDto userDto);

}
