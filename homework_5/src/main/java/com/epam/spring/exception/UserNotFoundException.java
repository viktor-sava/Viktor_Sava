package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
        super("User with the such email is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
