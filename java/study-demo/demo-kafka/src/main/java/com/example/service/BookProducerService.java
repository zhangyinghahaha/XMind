package com.example.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

/**
 * @author ying.zhang01
 */
@Service
public class BookProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public BookProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMsg(String topic, Object o) {
        try {
            SendResult<String, Object> sendResult = kafkaTemplate.send(topic, o).get();
            if (sendResult.getRecordMetadata() != null) {
                System.out.println(sendResult.getRecordMetadata().topic() + " -> " + sendResult.getProducerRecord().value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
