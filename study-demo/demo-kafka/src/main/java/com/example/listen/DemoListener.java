package com.example.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ying.zhang01
 */
@Component
public class DemoListener {
    private static final Logger log = LoggerFactory.getLogger(DemoListener.class);

    @KafkaListener(id = "demo", topics = "topic.quick.demo")
    public void listen(String msg) {
        log.info("demo receive: {}", msg);
    }
}
