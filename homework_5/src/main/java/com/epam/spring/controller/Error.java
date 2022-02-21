package com.epam.spring.controller;

import com.epam.spring.service.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Error {

    private String message;
    private ErrorType errorType;
    private LocalDateTime time;

}
