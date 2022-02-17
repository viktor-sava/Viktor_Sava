package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductDescriptionDto {

    @NotBlank(message = "'name' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotBlank(message = "'description' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @NotNull(message = "'language' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private LanguageDto language;

}
