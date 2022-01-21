package com.epam.spring.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE {
    private String name;
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
}
