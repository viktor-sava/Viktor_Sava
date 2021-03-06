package com.epam.spring.controller.dto;

import com.epam.spring.controller.dto.group.OnCreate;
import com.epam.spring.controller.dto.group.OnUpdate;
import com.epam.spring.service.constraints.anotations.LanguageConstraint;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class LanguageDto {

    @NotBlank(message = "'shortName' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @LanguageConstraint(message = "'shortName' of language is not valid", groups = {OnCreate.class, OnUpdate.class})
    private String shortName;

    @NotBlank(message = "'fullName' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String fullName;

}
