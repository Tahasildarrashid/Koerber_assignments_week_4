package com.bookapp.repository;

import com.bookapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bookrepository extends JpaRepository<Book, Integer> {

}
