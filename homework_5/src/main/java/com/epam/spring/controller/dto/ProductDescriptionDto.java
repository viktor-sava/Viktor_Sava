package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductDescriptionDto {

    @NotBlank(message = "'name' shouldn't be empty")
    private String name;

    @NotBlank(message = "'description' shouldn't be empty")
    private String description;

    @NotNull(message = "'language' shouldn't be empty")
    private LanguageDto language;

}
