package com.epam.spring.exception;

public class CategoryNotFoundException extends ServiceException {
    public CategoryNotFoundException() {
        super("Category is not found");
    }
}
