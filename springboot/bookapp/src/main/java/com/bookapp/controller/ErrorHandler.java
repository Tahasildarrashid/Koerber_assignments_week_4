package com.bookapp.controller;

import com.bookapp.exception.BookNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException e) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorMessage(e.getMessage())
                .timestamp(java.time.LocalDateTime.now())
                .errorCode(404)
                .toContact("Contact Admin")
                .build();
        return ResponseEntity.status(404).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorMessage(e.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")))
                .timestamp(java.time.LocalDateTime.now())
                .errorCode(400)
                .toContact("Contact Admin")
                .build();
        return ResponseEntity.status(400).body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorMessage("Something went wrong")
                .timestamp(java.time.LocalDateTime.now())
                .errorCode(500)
                .toContact("Contact Admin")
                .build();
        return ResponseEntity.status(500).body(errorDetails);
    }
}
