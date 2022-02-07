package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDto {

    private String shortName;

    private String fullName;

}
