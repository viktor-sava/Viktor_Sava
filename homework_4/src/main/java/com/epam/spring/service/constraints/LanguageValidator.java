package com.epam.spring.service.constraints;

import com.epam.spring.service.constraints.anotations.LanguageConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<LanguageConstraint, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field.toLowerCase().equals(field) && field.length() == 2;
    }
}
