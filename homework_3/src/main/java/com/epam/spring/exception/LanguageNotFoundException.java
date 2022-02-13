package com.epam.spring.exception;

public class LanguageNotFoundException extends ServiceException {
    public LanguageNotFoundException(String shortName) {
        super("Language with short name " + shortName + " is not found");
    }
}
