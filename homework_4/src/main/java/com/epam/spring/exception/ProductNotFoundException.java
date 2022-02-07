package com.epam.spring.exception;

public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException() {
        super("Product is not found!");
    }
}
