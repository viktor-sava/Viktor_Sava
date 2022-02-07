package com.epam.spring.exception;

public class ReceiptNotFoundException extends ServiceException {
    public ReceiptNotFoundException() {
        super("Receipt is not found!");
    }
}
