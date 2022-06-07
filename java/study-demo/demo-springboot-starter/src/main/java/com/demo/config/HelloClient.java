package com.demo.config;

/**
 * @author ying.zhang01
 */
public class HelloClient {
    private String name;

    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
