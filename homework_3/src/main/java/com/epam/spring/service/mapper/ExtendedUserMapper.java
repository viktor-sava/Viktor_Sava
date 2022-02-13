package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ExtendedUserDto;
import com.epam.spring.service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface ExtendedUserMapper {

    ExtendedUserDto mapUserDto(User user);

    User mapUser(ExtendedUserDto userDto);

}
