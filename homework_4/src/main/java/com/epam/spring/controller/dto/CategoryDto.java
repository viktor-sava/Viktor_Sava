package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
public class CategoryDto {

    @Null(message = "'id' should be absent in request")
    private int id;

    @NotBlank(message = "'name' shouldn't be empty")
    private String name;

}
