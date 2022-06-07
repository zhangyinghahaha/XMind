package com.demo.test;

import com.demo.config.HelloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTest {

    @Autowired
    private HelloClient helloClient;

    @Test
    public void testHello() {
        helloClient.sayHello();
    }
}