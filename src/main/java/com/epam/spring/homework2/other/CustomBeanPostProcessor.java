package com.epam.spring.homework2.other;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ValidationMark.class)) {
            try {
                Field name = bean.getClass().getDeclaredField("name");
                Field value = bean.getClass().getDeclaredField("value");
                name.setAccessible(true);
                value.setAccessible(true);
                boolean nonNull = name.get(bean) != null;
                boolean greaterThanZero = value.get(bean) instanceof Integer && (Integer) value.get(bean) > 0;
                if (nonNull && greaterThanZero) {
                    System.out.println(beanName + " is valid");
                } else {
                    if (!nonNull) {
                        System.out.println(beanName + " is not valid. Name can't be null");
                    }
                    if (!greaterThanZero) {
                        System.out.println(beanName + " is not valid. Value must be greater than zero");
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException ignored) {}
        }
        return bean;
    }
}
