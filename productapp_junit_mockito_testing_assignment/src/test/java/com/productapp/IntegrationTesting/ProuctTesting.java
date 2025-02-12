package com.productapp.IntegrationTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.entities.Product;
import com.productapp.repository.ProductRepo;
import com.productapp.service.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProuctTesting {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        productRepo.deleteAll();
    }

    @Test
    void givenBookObject_whenCreateBook_thenReturnSavedBook() throws Exception {
        Product product = Product.builder()
                .id(1)
                .name("Product 1")
                .price(BigDecimal.valueOf(100))
                .build();

        ResultActions response = mockMvc.perform(post("/api/produqt/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        response.andExpect(status -> status.isCreated())
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product));
    }


    @Test
    @AfterEach
    public void tearDown() {
        productRepo.deleteAll();
    }

}
