package com.example.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ying.zhang01
 */
public class KafkaConfig {

    /**
     * kafka监听器
     *
     * @param consumerFactory
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    /**
     * kafka消费者创建工厂
     *
     * @return
     */
    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }

    /**
     * 消费者配置参数
     *
     * @return
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>(10);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.6.110.190:9093");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "bootKafka");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    /**
     * kafka生产者工厂
     *
     * @return
     */
    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory<>(producerProps());
        factory.transactionCapable();
        factory.setTransactionIdPrefix("tran-");
        return factory;
    }

    @Bean
    public KafkaTransactionManager kafkaTransactionManager(ProducerFactory producerFactory) {
        KafkaTransactionManager manager = new KafkaTransactionManager(producerFactory);
        return manager;
    }

    private Map<String, Object> producerProps() {
        Map<String, Object> props = new HashMap<>(10);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.6.110.190:9093");
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024000);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate(ProducerFactory producerFactory) {
        KafkaTemplate<Integer, String> template = new KafkaTemplate<>(producerFactory);
        return template;
    }


}
