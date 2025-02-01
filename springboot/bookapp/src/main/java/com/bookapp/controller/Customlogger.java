package com.bookapp.controller;

import com.bookapp.entity.Book;
import com.bookapp.service.Bookservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class Customlogger {

    private Bookservice bookservice;

    public Customlogger(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        logger.info("Fetching all books");
        bookservice.getAllBooks().forEach(book -> logger.info(book.toString()));
        return ResponseEntity.status(HttpStatus.OK).body(bookservice.getAllBooks());
    }
}
