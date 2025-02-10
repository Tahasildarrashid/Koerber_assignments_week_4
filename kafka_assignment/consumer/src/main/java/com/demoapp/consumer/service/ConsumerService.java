package com.demoapp.consumer.service;

import org.springframework.core.annotation.Order;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ConsumerService {
    @KafkaListener(topics = "orders", groupId = "orders_group_id")
    public void consume(Order order) {
        System.out.println("Consumed message: " + order);
    }
}
