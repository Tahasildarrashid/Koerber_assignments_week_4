package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productserviceimplementation implements Productservice {

    private ProductRepository productRepository;

    @Autowired
    public Productserviceimplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProductSorted(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }
}
