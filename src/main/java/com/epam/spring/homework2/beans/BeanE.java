package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements BeanValidator {

    private String name;

    @Value("10")
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanE post construct method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanE pre destroy method");
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
