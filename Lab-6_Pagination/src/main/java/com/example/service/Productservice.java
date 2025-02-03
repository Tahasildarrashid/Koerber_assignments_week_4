package com.example.service;

import com.example.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Productservice {
    List<Product> getAllProductSorted(String field);
    Page<Product> getAllProductPage(int offset, int pageSize);
    Page<Product> getAllProductPageSorted(String field, int offset, int pageSize);
}
