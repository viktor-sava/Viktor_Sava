package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanB {

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

}
