package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.*;

@Configuration
@Import(AnotherConfig.class)
@PropertySource("classpath:application.properties")
public class Config {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}
