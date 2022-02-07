package com.epam.spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDescriptionDto {

    private String name;

    private String description;

    private LanguageDto language;

}
