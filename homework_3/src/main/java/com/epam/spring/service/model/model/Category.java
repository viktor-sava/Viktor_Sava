package com.epam.spring.service.model.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Category {

    private int id;

    private String name;

    private Timestamp modifiedDate;

}
