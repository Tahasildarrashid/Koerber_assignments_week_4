package com.bookapp;

import com.bookapp.entity.Book;
import com.bookapp.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

//@EnableScheduling
@SpringBootApplication
public class BookappApplication implements CommandLineRunner {
	@Autowired
	private Bookrepository bookrepository;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
