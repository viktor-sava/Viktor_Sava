package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.service.UserService;
import com.epam.spring.service.mapper.UserMapper;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
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
    public UserDto createUser(UserDto userDto) {
        log.info("User with email {} was created", userDto.getEmail());
        return userMapper.mapModelToDto(userRepository.createUser(userMapper.mapDtoToModel(userDto)));
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        userDto.setEmail(email);
        log.info("User with email {} was updated", userDto.getEmail());
        return userMapper.mapModelToDto(userRepository.updateUser(email, userMapper.mapDtoToModel(userDto)));
    }

    @Override
    public void blockUser(String email) {
        User user = userRepository.getUser(email);
        user.setBlocked(true);
        userRepository.updateUser(email, user);
        log.info("User with email {} was blocked", email);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
        log.info("User with email {} was deleted", email);
    }
}
