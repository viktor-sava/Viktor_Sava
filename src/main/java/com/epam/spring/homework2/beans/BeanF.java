package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.ValidationMark;

@ValidationMark
public class BeanF {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
