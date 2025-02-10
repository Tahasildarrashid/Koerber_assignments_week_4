package com.demoapp.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
}