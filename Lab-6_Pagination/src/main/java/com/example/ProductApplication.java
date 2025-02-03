package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class ProductApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Laptop", BigDecimal.valueOf(1000), LocalDate.now()));
		productRepository.save(new Product("Mobile", BigDecimal.valueOf(500), LocalDate.now()));
		productRepository.save(new Product("Television", BigDecimal.valueOf(2000), LocalDate.now()));
		productRepository.save(new Product("Washing Machine", BigDecimal.valueOf(1500), LocalDate.now()));
		productRepository.save(new Product("Camera", BigDecimal.valueOf(800), LocalDate.now()));
		productRepository.save(new Product("Table", BigDecimal.valueOf(100), LocalDate.now()));
		productRepository.save(new Product("Chair", BigDecimal.valueOf(100), LocalDate.now()));
		productRepository.save(new Product("Sofa", BigDecimal.valueOf(1000), LocalDate.now()));
		productRepository.save(new Product("Cupboard", BigDecimal.valueOf(500), LocalDate.now()));
		productRepository.save(new Product("Fan", BigDecimal.valueOf(200), LocalDate.now()));
	}
}
