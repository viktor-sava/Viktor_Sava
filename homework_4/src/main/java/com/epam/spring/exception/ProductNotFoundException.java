package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException(String name) {
        super("Product with name " + name + " is not found");
    }

    public ProductNotFoundException(int id) {
        super("Product with id " + id + " is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
