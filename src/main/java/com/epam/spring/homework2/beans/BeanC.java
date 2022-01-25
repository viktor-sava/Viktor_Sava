package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.factory.annotation.Value;

public class BeanC implements BeanValidator {

    @Value("${beanC.name}")
    private String name;

    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void initMethod() {
        System.out.println("Init method of BeanC");
    }

    public void destroyMethod() {
        System.out.println("Destroy method of BeanC");
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
