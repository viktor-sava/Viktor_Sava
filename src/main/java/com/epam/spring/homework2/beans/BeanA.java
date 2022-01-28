package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@ValidationMark
public class BeanA implements InitializingBean, DisposableBean {

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
}
