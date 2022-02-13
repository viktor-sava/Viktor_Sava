package com.epam.spring.service.constraints;

import com.epam.spring.service.constraints.anotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field.matches("[0-9]{8,14}");
    }
}
