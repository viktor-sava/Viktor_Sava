package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.epam.spring.service.constraints.anotations.Phone;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @NotBlank(message = "'surname' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String surname;

    @NotBlank(message = "'name' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotBlank(message = "'patronymic' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String patronymic;

    @Email(groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "'email' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotBlank(message = "'phone' shouldn't be empty", groups = OnCreate.class)
    @Phone(message = "'phone' is not valid", groups = OnCreate.class)
    private String phone;

    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'password' should be absent in request", groups = OnUpdate.class)
    private String password;

    @NotBlank(message = "'repeatPassword' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'repeatPassword' should be absent in request", groups = OnUpdate.class)
    private String repeatPassword;

    @Null(message = "'blocked' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Boolean blocked;

    @NotNull(message = "'admin' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private Boolean admin;

}
