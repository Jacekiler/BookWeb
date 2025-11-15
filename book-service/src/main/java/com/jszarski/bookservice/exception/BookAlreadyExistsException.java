package com.jszarski.bookservice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookAlreadyExistsException extends RuntimeException {


    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
