package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class LanguageNotFoundException extends ServiceException {
    public LanguageNotFoundException(String shortName) {
        super("Language with short name " + shortName + " is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
