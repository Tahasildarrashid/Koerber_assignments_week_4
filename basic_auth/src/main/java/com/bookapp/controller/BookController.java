package com.bookapp.controller;

import com.bookapp.entities.Book;
import com.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }

    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @GetMapping(path="books/{id}")
    public Book getById(@PathVariable int id){
        return bookService.getById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    @DeleteMapping("books/delete/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
