package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CategoryDto {

    private int id;

    private String name;

    private Timestamp modifiedDate;

}
