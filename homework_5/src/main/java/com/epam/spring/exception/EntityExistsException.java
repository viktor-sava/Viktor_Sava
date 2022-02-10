package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class EntityExistsException extends ServiceException {
    public EntityExistsException() {
        super("Entity with such data is already exists");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
