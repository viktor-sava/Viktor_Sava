package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.exception.EntityExistsException;
import com.epam.spring.exception.UserNotFoundException;
import com.epam.spring.service.UserService;
import com.epam.spring.service.mapper.UserMapper;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        return userMapper.mapUserDto(userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<UserDto> listUsers() {
        return userRepository.findAll().stream().map(userMapper::mapUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EntityExistsException();
        }
        return userMapper.mapUserDto(userRepository.save(userMapper.mapUser(userDto)));
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        userDto.setEmail(email);
        return userMapper.mapUserDto(userRepository.save(userMapper.mapUser(userDto)));
    }

    @Override
    public void blockUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        user.setBlocked(true);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }
}
