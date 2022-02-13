package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String email) {
        super("User with email " + email + " is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
