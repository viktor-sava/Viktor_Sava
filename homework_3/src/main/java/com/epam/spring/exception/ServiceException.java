package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public abstract class ServiceException extends RuntimeException {

    protected ServiceException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }

}
