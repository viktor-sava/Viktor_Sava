package com.epam.spring.exception;

public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
        super("User with the such email is not found");
    }
}
