package com.epam.spring.exception;

import com.epam.spring.service.enums.ErrorType;

public class ReceiptNotFoundException extends ServiceException {
    public ReceiptNotFoundException() {
        super("Receipt is not found");
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
