package com.nowcoder.community;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@SpringBootTest
public class KafkaTest {
    @Autowired
    private KafkaProducer producer;

    @Test
    public void testKafka() throws InterruptedException {
        producer.sendMsg("test", "hello kafka");
        producer.sendMsg("test", "hello zhang ying");

        Thread.sleep(1000*10);
    }
}

@Component
class KafkaProducer {
    @Autowired
    public KafkaTemplate kafkaTemplate;

    public void sendMsg(String topic, String content) {
        kafkaTemplate.send(topic, content);
    }
}

@Component
class KafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void handleMsg(ConsumerRecord record) {
        System.out.println(record.value());
    }
}