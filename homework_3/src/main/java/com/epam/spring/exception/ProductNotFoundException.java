package com.epam.spring.exception;

public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException(String name) {
        super("Product with name " + name + " is not found");
    }

    public ProductNotFoundException(int id) {
        super("Product with id " + id + " is not found");
    }
}
