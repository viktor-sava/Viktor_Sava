package com.epam.spring.homework2.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Objects;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try {
            Field name = bean.getClass().getDeclaredField("name");
            Field value = bean.getClass().getDeclaredField("value");
            name.setAccessible(true);
            value.setAccessible(true);
            if (Objects.nonNull(name.get(bean)) || (value.get(bean) instanceof Integer && (Integer) value.get(bean) > 0)) {
                System.out.println(beanName + " is valid");
            } else {
                System.out.println(beanName + " is not valid");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
        return bean;
    }
}
