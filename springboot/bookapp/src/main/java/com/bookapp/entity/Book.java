package com.bookapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name="book_isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @NotBlank
    @Column(name="book_title", nullable = false, length = 20)
    private String title;

    @NotBlank
    @Column(name="book_category", nullable = false, length = 20)
    private String category;

    @NotBlank
    @Column(name="book_author", nullable = false, length = 20)
    private String author;

    @NotNull
    @Column(name="book_price", nullable = false)
    private BigDecimal price;

}