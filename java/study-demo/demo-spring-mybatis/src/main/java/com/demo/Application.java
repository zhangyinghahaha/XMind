package com.demo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangying
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        HelloSpring helloSpring = context.getBean(HelloSpring.class);
//        helloSpring.say();

        SqlSessionTemplate sqlSessionTemplate = context.getBean(SqlSessionTemplate.class);

        OrderDao orderDao = context.getBean(OrderDao.class);
        Order order = orderDao.queryOrderByNumber(20005);
        System.out.println(order);

        // OrderMapper orderMapper = sqlSessionTemplate.getMapper(OrderMapper.class);
        OrderMapper orderMapper = context.getBean(OrderMapper.class);
        order = orderMapper.queryOrderByNumber(20005);
        System.out.println(order);
    }
}
