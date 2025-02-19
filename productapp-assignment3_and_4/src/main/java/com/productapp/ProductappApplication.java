package com.productapp;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		insert();
		productRepo.getProdcutById(1).ifPresent(System.out::println);

		List<Product> productsByQtyLessThan = productRepo.getProductsByQtyLessThan(20);
		System.out.println(productsByQtyLessThan);

		List<Product> getProductsByVendor = productRepo.getProductsByVendor("");
		System.out.println(getProductsByVendor);

		List<Product> ans = productRepo.getProductdByPagesGreaterThanEqual(23);
		System.out.println(ans);

		List<Product> ans1 = productRepo.getProductsByVendorAndCost("AB electronic", 500.0);
		System.out.println(ans1);

		List<Product> ans2 = productRepo.getProductsByVendorOrName("AB electronic", "dell laptop");
		System.out.println(ans2);

		List<Product> ans3 = productRepo.getProductsByVendorSortByName("AB electronic");
		System.out.println(ans3);

		List<Product> ans4 = productRepo.getProductNameAndVendorByQty(30);
		System.out.println(ans4);

		List<Product> ans5 = productRepo.getAllProductByVendor("AB electronic");
		System.out.println(ans5);

		List<Product> ans6 = productRepo.getProductsByVendorRegEx("AB electronic");
		System.out.println(ans6);

		Integer count = productRepo.getProductsCountByVendor("AB electronic");
		System.out.println(count);

	}

	private void insert() {
		productRepo.save(new Product("dell laptop", 30, "AB electronic", 5000000.0));
		productRepo.save(new Product("mouse", 300, "MA electronic", 500.0));
		productRepo.save(new Product("Keyboard", 20, "ZA electronic", 600.0));
		productRepo.save(new Product("printer", 10, "CD electronic", 20000.0));
		System.out.println("------------------------");
	}
}
