package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangying
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        HelloSpring helloSpring = context.getBean(HelloSpring.class);
        helloSpring.say();
    }
}
