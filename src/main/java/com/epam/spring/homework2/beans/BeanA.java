package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class BeanA implements InitializingBean, DisposableBean, BeanValidator {

    @Value("BeanA")
    private String name;

    @Value("5")
    private int value;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Implemented InitializingBean method (init) of BeanA");
    }

    @Override
    public void destroy() {
        System.out.println("Implemented DisposableBean method (destroy) of BeanA");
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
