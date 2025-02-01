package com.bookapp.service;

import com.bookapp.entity.Book;

import java.util.List;

public interface Bookservice {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public Book save(Book book);
    public Book updateBook(int id, Book book);
    public void deleteBook(int id);
}
