package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.factory.annotation.Value;

@ValidationMark
public class BeanD {

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

}
