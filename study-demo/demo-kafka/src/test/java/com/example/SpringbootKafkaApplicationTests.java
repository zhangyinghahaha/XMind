package com.example;

import com.example.listen.KafkaProducerListener;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class SpringbootKafkaApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private AdminClient adminClient;

    @Test
    public void test() throws InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "this is my first demo");
        ProducerRecord record = new ProducerRecord("topic.quick.demo", "use producerrecord");
        kafkaTemplate.send(record);
        Thread.sleep(5000);
    }

    @Test
    public void testCreateTopic() throws InterruptedException {
        NewTopic topic = new NewTopic("topic.quick.initial2", 3, (short) 1);
        adminClient.createTopics(Arrays.asList(topic));
        Thread.sleep(1000);
    }

    @Test
    public void testSelectTopic() throws ExecutionException, InterruptedException {
        DescribeTopicsResult result = adminClient.describeTopics(Arrays.asList("topic.quick.initial"));
        result.all().get().forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v.toString() + "\n");
        });
    }

    @Test
    public void testProducerListener() throws InterruptedException {
        kafkaTemplate.setProducerListener(new KafkaProducerListener());
        kafkaTemplate.send("topic.quick.demo", "test producer listener");
        Thread.sleep(1000);
    }

}
