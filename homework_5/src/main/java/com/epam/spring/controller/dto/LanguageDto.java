package com.epam.spring.controller.dto;

import com.epam.spring.service.constraints.anotations.LanguageConstraint;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class LanguageDto {

    @LanguageConstraint
    private String shortName;

    @NotBlank(message = "'fullName' shouldn't be empty")
    private String fullName;

}
