package com.nowcoder.community.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ying.zhang01
 */
@Configuration
@EnableConfigurationProperties(WKProperties.class)
public class WKConfig {

    private static final Logger logger = LoggerFactory.getLogger(WKConfig.class);

    @Autowired
    private WKProperties wkProperties;

    @PostConstruct
    public void init() throws IOException {
        Path path = Paths.get(wkProperties.getStorage());
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            logger.info("创建wk图片目录:" + path);
        }
    }
}
