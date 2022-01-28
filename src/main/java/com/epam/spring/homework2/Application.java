package com.epam.spring.homework2;

import com.epam.spring.homework2.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("############### Starting context... ###############");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("############### List of all beans ###############");
        Arrays.stream(context.getBeanDefinitionNames()).forEach((s) -> System.out.println(context.getBeanDefinition(s)));
        System.out.println("############### End of list of all beans ###############");
        System.out.println("############### Closing context... ###############");
        context.close();
    }
}
