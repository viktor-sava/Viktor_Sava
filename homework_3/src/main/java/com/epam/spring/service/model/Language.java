package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Language {

    private int id;

    private String shortName;

    private String fullName;

}
