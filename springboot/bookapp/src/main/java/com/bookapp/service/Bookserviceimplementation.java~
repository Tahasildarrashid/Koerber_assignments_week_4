package com.bookapp.service;

import com.bookapp.entity.Book;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.loggable.Logger;
import com.bookapp.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookserviceimplementation implements Bookservice {

    private Bookrepository bookrepository;

    @Autowired
    public Bookserviceimplementation(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookrepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookrepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public Book save(Book book) {
        return bookrepository.save(book);
    }

    @Logger
    @Override
    public void deleteBook(int id) {
        Book bookToDelete = getBookById(id);
        bookrepository.delete(bookToDelete);
    }

    @Logger
    @Override
    public Book updateBook(int id, Book book) {
        Book bookToUpdate = getBookById(id);
        bookToUpdate.setPrice(book.getPrice());
        bookrepository.save(bookToUpdate);

        return bookToUpdate;
    }
}
