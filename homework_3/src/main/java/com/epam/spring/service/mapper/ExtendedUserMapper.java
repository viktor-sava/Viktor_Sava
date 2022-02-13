package com.epam.spring.service.mapper;

import com.epam.spring.controller.dto.ExtendedUserDto;
import com.epam.spring.service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface ExtendedUserMapper {

    ExtendedUserDto mapModelToDto(User user);

    User mapDtoToModel(ExtendedUserDto userDto);

}
