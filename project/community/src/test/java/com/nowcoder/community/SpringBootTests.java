package com.nowcoder.community;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@SpringBootTest
public class SpringBootTests {
    @BeforeAll
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("after class");
    }

    @BeforeEach
    public void beforeMethod() {
        System.out.println("before method");
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("after method");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
