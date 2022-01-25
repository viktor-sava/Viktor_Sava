package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.factory.annotation.Value;

public class BeanB implements BeanValidator {

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void anotherInitMethod() {
        System.out.println("Another init method of BeanB");
    }

    public void initMethod() {
        System.out.println("Init method of BeanB");
    }

    public void destroyMethod() {
        System.out.println("Destroy method of BeanB");
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
