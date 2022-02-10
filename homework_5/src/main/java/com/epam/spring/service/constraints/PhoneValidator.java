package com.epam.spring.service.constraints;

import com.epam.spring.service.constraints.anotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field != null && field.matches("[0-9]+") && (field.length() > 8) && (field.length() < 14);
    }
}
