package com.epam.spring.service.constraints.anotations;

import com.epam.spring.service.constraints.LanguageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LanguageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LanguageConstraint {
    String message() default "Invalid short name of language";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
