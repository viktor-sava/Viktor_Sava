package com.epam.spring.service.impl;

import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.exception.EntityExistsException;
import com.epam.spring.exception.UserNotFoundException;
import com.epam.spring.service.UserService;
import com.epam.spring.service.mapper.UserMapper;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import com.epam.spring.service.utils.OptionalPageable;
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
        return userMapper.mapModelToDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email)));
    }

    @Override
    public List<UserDto> listUsers() {
        return listUsers(null, null, new String[0]);
    }

    @Override
    public List<UserDto> listUsers(Integer page, Integer size, String[] fields) {
        return userRepository.findAll(OptionalPageable.ofNullable(page, size, fields))
                .stream()
                .map(userMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EntityExistsException("User with such email already exists");
        }
        log.info("User with email {} was created", userDto.getEmail());
        return userMapper.mapModelToDto(userRepository.save(userMapper.mapDtoToModel(userDto)));
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        if (!userRepository.existsByEmail(email)) {
            throw new UserNotFoundException(email);
        }
        userDto.setEmail(email);
        log.info("User with email {} was updated", userDto.getEmail());
        return userMapper.mapModelToDto(userRepository.save(userMapper.mapDtoToModel(userDto)));
    }

    @Override
    public void blockUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
        user.setBlocked(true);
        userRepository.save(user);
        log.info("User with email {} was blocked", email);
    }

    @Override
    public void unblockUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
        user.setBlocked(false);
        userRepository.save(user);
        log.info("User with email {} was unblocked", email);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
        log.info("User with email {} was deleted", email);
    }
}
