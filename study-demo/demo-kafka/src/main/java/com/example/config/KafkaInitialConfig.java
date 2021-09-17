package com.example.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ying.zhang01
 */
public class KafkaInitialConfig {
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = new HashMap<>(5);
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.6.110.190:9093");
        KafkaAdmin kafkaAdmin = new KafkaAdmin(props);
        return kafkaAdmin;
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfigurationProperties());
    }

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic.quick.initial", 8, (short) 1);
    }
}
