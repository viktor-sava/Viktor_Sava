package com.epam.spring.exception;

public class ReceiptNotFoundException extends ServiceException {

    public ReceiptNotFoundException(int id) {
        super("Receipt with id " + id + " is not found");
    }
}
