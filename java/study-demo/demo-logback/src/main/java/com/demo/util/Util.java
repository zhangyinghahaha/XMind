package com.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
    private static final Logger log = LoggerFactory.getLogger(Util.class);

    public static void loginfo() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
