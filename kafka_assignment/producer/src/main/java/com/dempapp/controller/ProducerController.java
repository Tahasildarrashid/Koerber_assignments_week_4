package com.dempapp.controller;

import com.dempapp.dto.Order;
import com.dempapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {
    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public void sendMessage(@RequestBody Order order) {
        producerService.sendMessage(order);
    }
}
