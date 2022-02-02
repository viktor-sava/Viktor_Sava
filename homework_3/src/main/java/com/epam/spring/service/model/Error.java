package com.epam.spring.service.model;

import com.epam.spring.service.model.enums.ErrorType;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Error {

    private String message;
    private ErrorType errorType;
    private LocalDateTime time;

}
