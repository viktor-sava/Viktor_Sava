package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class User {

    private int id;

    private String surname;

    private String name;

    private String patronymic;

    private String email;

    private String phone;

    private String password;

    private Timestamp createDate;

    private boolean blocked;

    private boolean admin;

}
