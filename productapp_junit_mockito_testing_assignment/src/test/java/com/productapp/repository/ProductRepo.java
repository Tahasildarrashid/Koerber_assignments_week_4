package com.productapp.repository;

import com.productapp.entities.Product;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
public class ProductRepo {

    @Autowired
    private ProductRepo productRepo;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Product 1", BigDecimal.valueOf(100));
    }

    @Test
    @DisplayName("Save book")
    public void save() {
        when(productRepo.save(product)).thenReturn(product);
        Product savedBook = productRepo.save(product);
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isEqualTo("123");
    }

    @Test
    @DisplayName("Delete book")
    public void delete() {
        when(productRepo.getProductById(1)).thenReturn(Optional.of(product));
        assertThat(product).isNull();
    }

    @AfterEach
    public void tearDown() {
        product = null;
    }
}
