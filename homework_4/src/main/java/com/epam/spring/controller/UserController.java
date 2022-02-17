package com.epam.spring.controller;

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
    @PutMapping("/{email}/block")
    public UserDto blockUser(@PathVariable String email) {
        userService.blockUser(email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}/unblock")
    public UserDto unblockUser(@PathVariable String email) {
        userService.unblockUser(email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto) {
        log.info("updateUser by email {}", email);
            return userService.updateUser(email, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        log.info("deleteUser by email {}", email);
        userService.deleteUser(email);
    }

}
