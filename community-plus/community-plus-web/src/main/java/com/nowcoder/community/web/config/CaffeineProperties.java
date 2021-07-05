package com.nowcoder.community.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ying.zhang01
 */
@ConfigurationProperties(prefix = "caffeine.posts")
public class CaffeineProperties {
    private int maxSize;
    private int expireSeconds;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}
