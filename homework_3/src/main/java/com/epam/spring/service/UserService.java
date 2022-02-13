package com.epam.spring.service;

import com.epam.spring.controller.dto.ExtendedUserDto;
import com.epam.spring.controller.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    List<UserDto> listUsers();

    UserDto createUser(ExtendedUserDto userDto);

    UserDto updateUser(String email, ExtendedUserDto userDto);

    void blockUser(String email);

    void deleteUser(String email);

}
