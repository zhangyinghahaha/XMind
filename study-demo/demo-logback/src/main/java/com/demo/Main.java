package com.demo;

import com.demo.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static void loginfo() {
        log.trace("Hello, [{}]", "trace");
        log.debug("Hello, [{}]", "debug");
        log.info("Hello, [{}]", "info");
        log.warn("Hello, [{}]", "warn");
        log.error("Hello, [{}]", "error");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            loginfo();
            Util.loginfo();
        }
    }
}
