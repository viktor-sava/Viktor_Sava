package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;

public class BeanF implements BeanValidator {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void validate() {
        System.out.println("Validation of " + this);
        if (name != null && value > 0) {
            System.out.println(getClass().getSimpleName() + " is valid");
        } else {
            System.out.println(getClass().getSimpleName() + " is not valid");
        }
    }

}
