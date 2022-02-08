package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class CategoryNotFoundException extends ServiceException {
    public CategoryNotFoundException() {
        super("Category is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
