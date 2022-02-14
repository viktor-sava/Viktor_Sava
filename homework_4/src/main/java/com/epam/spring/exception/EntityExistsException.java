package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class EntityExistsException extends ServiceException {
    public EntityExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
