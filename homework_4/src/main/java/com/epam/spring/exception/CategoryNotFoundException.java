package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class CategoryNotFoundException extends ServiceException {
    public CategoryNotFoundException(String categoryName) {
        super("Category with name " + categoryName + " is not found");
    }

    public CategoryNotFoundException(int id) {
        super("Category with id " + id + " is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
