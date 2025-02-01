package com.bookapp.controller;

import com.bookapp.entity.Book;
import com.bookapp.service.Bookservice;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    private Bookservice bookservice;

    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @GetMapping("/books")
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<Book> books = bookservice.getAllBooks();
        List<EntityModel<Book>> bookResources = books.stream()
                .map(book -> {
                    EntityModel<Book> bookModel = EntityModel.of(book);
                    bookModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
                    return bookModel;
                })
                .collect(Collectors.toList());

        return CollectionModel.of(bookResources);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookservice.getBookById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> save(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookservice.save(book));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody @Valid Book book) {
        book.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookservice.save(book));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookservice.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
