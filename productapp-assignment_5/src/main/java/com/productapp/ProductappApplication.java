package com.productapp;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.List;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	private void insert() {
		productRepo.save(new Product("dell laptop", 30, "AB electronic", 5000000.0));
		productRepo.save(new Product("mouse", 300, "MA electronic", 500.0));
		productRepo.save(new Product("Keyboard", 20, "ZA electronic", 600.0));
		productRepo.save(new Product("printer", 10, "CD electronic", 20000.0));
		System.out.println("------------------------");
	}

	public List<Product> products()
	{
		List<Product> products = mongoTemplate.findAll(Product.class);
		return products;
	}

	public List<Product> productsByVendor(String vendor)
	{
		Query query = new Query(Criteria.where("vendor").is(vendor));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> findProductByQtsGreaterThanEqual(Integer qty)
	{
		Query query = new Query(Criteria.where("qty").gte(qty));
		return mongoTemplate.find(query, Product.class);
	}

	public void upsert(){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("dell laptop"));
		Update update = new Update();
		update.set("cost", 6000000.0);
		mongoTemplate.updateFirst(query, update, Product.class);
	}

	private void findAndRemove(){
		System.out.println(mongoTemplate.findAndRemove(new Query(Criteria.where("name").is("dell laptop")), Product.class));
	}

	private void updateMulti(){
		System.out.println(mongoTemplate.updateMulti(new Query(Criteria.where("name").is("dell laptop")), new Update().inc("qty", 10), Product.class));
	}

	private void findAndModify(){
		System.out.println(mongoTemplate.findAndModify(new Query(Criteria.where("name").is("dell laptop")), new Update().inc("qty", 10), Product.class));
	}

	private void findALl(){
		System.out.println(mongoTemplate.findAll(Product.class));
	}

	private void findById(){
		System.out.println(mongoTemplate.findById("5f9b3b4b9b4b4b4b4b4b4b4b", Product.class));
	}

	private void insertAll(){
		mongoTemplate.insertAll(List.of(new Product("dell laptop", 30, "AB electronic", 5000000.0),
				new Product("mouse", 300, "MA electronic", 500.0),
				new Product("Keyboard", 20, "ZA electronic", 600.0),
				new Product("printer", 10, "CD electronic", 20000.0)));
	}

	private void insertWithCollectionName(){
		mongoTemplate.insert(List.of(new Product("dell laptop", 30, "AB electronic", 5000000.0),
				new Product("mouse", 300, "MA electronic", 500.0),
				new Product("Keyboard", 20, "ZA electronic", 600.0),
				new Product("printer", 10, "CD electronic", 20000.0)), "product_collection");
	}



}
