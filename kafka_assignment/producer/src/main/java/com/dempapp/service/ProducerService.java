package com.dempapp.service;

import com.dempapp.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    public void sendMessage(Order order) {
        kafkaTemplate.send(topic, order);
    }
}
