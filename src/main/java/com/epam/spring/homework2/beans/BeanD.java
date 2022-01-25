package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.factory.annotation.Value;

public class BeanD implements BeanValidator {

    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void initMethod() {
        System.out.println("Init method of BeanD");
    }

    public void destroyMethod() {
        System.out.println("Destroy method of BeanD");
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
