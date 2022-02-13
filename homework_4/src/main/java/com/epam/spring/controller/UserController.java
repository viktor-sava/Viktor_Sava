package com.epam.spring.controller;

import com.epam.spring.controller.dto.ExtendedUserDto;
import com.epam.spring.controller.dto.UserDto;
import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.epam.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("getAllUsers");
        return userService.listUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        log.info("getUser by email {}", email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}/block")
    public UserDto blockUser(@PathVariable String email) {
        userService.blockUser(email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody @Validated ExtendedUserDto extendedUserDto) {
        log.info("createUser with email {}", extendedUserDto.getEmail());
        return userService.createUser(extendedUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody @Validated (OnUpdate.class) ExtendedUserDto extendedUserDto) {
        log.info("updateUser by email {}", email);
            return userService.updateUser(email, extendedUserDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        log.info("deleteUser by email {}", email);
        userService.deleteUser(email);
    }

}
