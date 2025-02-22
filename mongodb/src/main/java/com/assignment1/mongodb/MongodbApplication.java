package com.assignment1.mongodb;

import com.assignment1.mongodb.entity.Peak;
import com.assignment1.mongodb.repository.Mountainrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

	@Autowired
	private Mountainrepo mountainrepo;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	List<Peak> Mountains = mountainrepo.findAll();

	public void printMountains() {
		for (Peak mountain : Mountains) {
			System.out.println(mountain);
		}
	}

	List<Peak> Mountains1 = mountainrepo.findByName("Everest");

	List<Peak> Mountains2 = mountainrepo.findByHeightGreaterThan(8000);

	List<Peak> Mountains3 = mountainrepo.findByNameAndHeight("Everest", 8848);

	List<Peak> Mountains4 = mountainrepo.findByNameOrHeight("Everest", 8848);

	List<Peak> Mountains5 = mountainrepo.findByLocationIn(List.of("China", "Nepal"));

	List<Peak> Mountains6 = mountainrepo.findByAscentsTotalGreaterThan(1000);

	@Override
	public void run(String... args) throws Exception {
		printMountains();
	}
}
