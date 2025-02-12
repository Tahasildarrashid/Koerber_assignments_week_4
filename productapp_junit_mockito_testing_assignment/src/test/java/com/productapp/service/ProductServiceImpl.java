package com.productapp.service;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImpl {

    @Mock
    private ProductRepo productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Product 1", BigDecimal.valueOf(100));
    }

    @Test
    @DisplayName("Get product by id")
    void getProductById() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        ProductDto p = productService.getProductById(1);
        assertThat(p.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(100.00));
    }

    @DisplayName("Save book")
    @Test
    void save() {
        when(productRepository.save(product)).thenReturn(product);
        Product savedBook = productService.save(product);
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isEqualTo("123");
    }

    @Test
    @DisplayName("Delete book")
    void delete() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        assertThat(product).isNull();
    }

    @AfterEach
    public void tearDown() {
        product = null;
    }

}
