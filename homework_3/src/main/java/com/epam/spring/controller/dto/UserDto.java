package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String surname;

    private String name;

    private String patronymic;

    private String email;

    private String phone;

    private boolean blocked;

    private boolean admin;

}
