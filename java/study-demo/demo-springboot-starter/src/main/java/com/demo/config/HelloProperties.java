package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ying.zhang01
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private String name = "zhang ying";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
