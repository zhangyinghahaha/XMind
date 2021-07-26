package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public static void main(String[] args) {
        String name = "zhang ying";
        logger.trace("trace");
        logger.debug("debug");
        logger.info("Hello, {}", name);
        logger.warn("warn");
        logger.error("error");
    }
}
