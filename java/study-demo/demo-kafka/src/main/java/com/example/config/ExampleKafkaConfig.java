package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * @author ying.zhang01
 */
@Configuration
public class ExampleKafkaConfig {
    @Value("${example.topic.example-topic1}")
    private String exampleTopic1;

    @Value("${example.topic.example-topic2}")
    private String exampleTopic2;

    @Bean
    public RecordMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    /**
     * 通过注入一个 NewTopic 类型的 Bean 来创建 topic，如果 topic 已存在，则会忽略。
     */
    @Bean
    public NewTopic exampleTopic1() {
        return new NewTopic(exampleTopic1, 2, (short) 1);
    }

    @Bean
    public NewTopic exampleTopic2() {
        return new NewTopic(exampleTopic2, 1, (short) 1);
    }
}
