package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanC {

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
}
