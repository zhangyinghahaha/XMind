package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ying.zhang01
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Value("${example.topic.example-topic1}")
    String myTopic;
    @Value("${example.topic.example-topic2}")
    String myTopic2;
    private final BookProducerService producer;
    private AtomicLong atomicLong = new AtomicLong();

    BookController(BookProducerService producer) {
        this.producer = producer;
    }

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
        this.producer.sendMsg(myTopic, new Book(atomicLong.addAndGet(1), name));
        this.producer.sendMsg(myTopic2, new Book(atomicLong.addAndGet(1), name));
    }
}
