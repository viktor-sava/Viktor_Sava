package com.epam.spring.homework1.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OtherBeanC {

    @Autowired
    private OtherBeanC beanC;

    public OtherBeanC() {
        System.out.println(beanC); // Значення beanC буде null, оскільки OtherBeanC ще не створений
        // Щоб виконати якійсь дії над об`єктом, варто використовувати PostConstruct
    }
    /*
    @PostConstruct
    public void postConstruct() {
        System.out.println(beanC.getClass().getSimpleName());
    }
    */
}
