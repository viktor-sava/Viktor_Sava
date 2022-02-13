package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.ExtendedUserDto;
import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.service.UserService;
import com.epam.spring.service.mapper.ExtendedUserMapper;
import com.epam.spring.service.mapper.UserMapper;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ExtendedUserMapper extendedUserMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        return userMapper.mapModelToDto(userRepository.getUser(email));
    }

    @Override
    public List<UserDto> listUsers() {
        return userRepository.listUsers()
                .stream()
                .map(userMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(ExtendedUserDto userDto) {
        return userMapper.mapModelToDto(userRepository.createUser(extendedUserMapper.mapDtoToModel(userDto)));
    }

    @Override
    public UserDto updateUser(String email, ExtendedUserDto userDto) {
        userDto.setEmail(email);
        return userMapper.mapModelToDto(userRepository.updateUser(email, extendedUserMapper.mapDtoToModel(userDto)));
    }

    @Override
    public void blockUser(String email) {
        User user = userRepository.getUser(email);
        user.setBlocked(true);
        userRepository.updateUser(email, user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
}
