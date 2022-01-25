package com.epam.spring.homework2.other;

import com.epam.spring.homework2.validation.BeanValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanValidator) {
            ((BeanValidator) bean).validate();
        }
        return bean;
    }
}
