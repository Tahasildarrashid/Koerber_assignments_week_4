package com.example.demo;

import com.example.demo.entity.Peaks;
import com.example.demo.repository.Peakrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private Peakrepository peakrepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		peakrepository.findByFirstWinterAscendedAfter2000().forEach(System.out::println);

		peakrepository.findByNameEverestAndHeight8848().forEach(System.out::println);

		peakrepository.findByLocationChinaAndNepal().forEach(System.out::println);

		peakrepository.findAllExcludingAscentsAndLocation().forEach(System.out::println);
	}

}
