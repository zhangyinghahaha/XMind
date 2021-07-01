package com.nowcoder.community.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ying.zhang01
 */
@ConfigurationProperties(prefix = "wk.image")
public class WKProperties {
    private String command;
    private String storage;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
