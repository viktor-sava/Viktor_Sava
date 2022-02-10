package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class LanguageNotFoundException extends ServiceException {
    public LanguageNotFoundException() {
        super("Language is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
