package com.epam.spring.service.model.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDescription {

    private String name;

    private String description;

    private Language language;

}
