package com.productapp.service;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product book) {
        return productRepo.save(book);
    }

    @Override
    public Product update(String id, Product book) {
        Product productToUpdate = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productToUpdate.setName(book.getName());
        productToUpdate.setQty(book.getQty());
        productToUpdate.setVendor(book.getVendor());
        productToUpdate.setCost(book.getCost());
        return productRepo.save(book);
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).get();
    }
}
