package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException() {
        super("Product is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
