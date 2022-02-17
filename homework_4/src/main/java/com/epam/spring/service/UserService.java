package com.epam.spring.service;

import com.epam.spring.controller.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    List<UserDto> listUsers();

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void blockUser(String email);

    void unblockUser(String email);

    void deleteUser(String email);

}
