package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@Import(AnotherConfig.class)
@PropertySource("classpath:application.properties")
public class Config {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Order(1)
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Order(2)
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Order(3)
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}