package com.jszarski.bookservice.controller;

import com.jszarski.bookservice.exception.BookAlreadyExistsException;
import com.jszarski.bookservice.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = BookAlreadyExistsException.class)
    public ResponseEntity<String> bookAlreadyExists(BookAlreadyExistsException exception){
        log.debug("Exception handler: BookAlreadyExistsException");
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(exception = BookNotFoundException.class)
    public ResponseEntity<String> bookAlreadyExists(BookNotFoundException exception){
        log.debug("Exception handler: BookNotFoundException");
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
