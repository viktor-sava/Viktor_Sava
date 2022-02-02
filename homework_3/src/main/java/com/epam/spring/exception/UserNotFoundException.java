package com.epam.spring.exception;

public class UserNotFoundException extends ServiceException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
