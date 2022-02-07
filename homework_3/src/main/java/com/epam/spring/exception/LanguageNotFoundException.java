package com.epam.spring.exception;

public class LanguageNotFoundException extends ServiceException {
    public LanguageNotFoundException() {
        super("Language is not found!");
    }
}
