package com.example.controller;

import com.example.entity.Product;
import com.example.service.Productservice;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private Productservice productservice;

    @GetMapping("products")
    public List<Product> getAllProductSorted(@RequestParam(name="field")  String field) {
        return productservice.getAllProductSorted(field);
    }

    @GetMapping("productspage")
    public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset, @RequestParam(name="pageSize") int pageSize) {
        return productservice.getAllProductPage(offset, pageSize);
    }

    @GetMapping("productspagesorted")
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productservice.getAllProductPageSorted(field, offset, pageSize);
    }
}
