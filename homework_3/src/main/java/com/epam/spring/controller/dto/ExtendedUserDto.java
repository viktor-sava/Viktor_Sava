package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExtendedUserDto {

    private String surname;

    private String name;

    private String patronymic;

    private String email;

    private String phone;

    private String password;

    private String repeatPassword;

    private boolean blocked;

    private boolean admin;

}
