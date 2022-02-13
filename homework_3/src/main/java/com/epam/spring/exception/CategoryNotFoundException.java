package com.epam.spring.exception;

public class CategoryNotFoundException extends ServiceException {
    public CategoryNotFoundException(String categoryName) {
        super("Category with name " + categoryName + " is not found");
    }

    public CategoryNotFoundException(int id) {
        super("Category with id " + id + " is not found");
    }
}
