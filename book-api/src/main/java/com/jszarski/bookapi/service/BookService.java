package com.jszarski.bookapi.service;

import com.jszarski.bookapi.client.BookServiceClient;
import com.jszarski.bookapi.model.dto.BookDTO;
import com.jszarski.bookapi.model.dto.BookRatingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookService {

    private final BookServiceClient bookServiceClient;

    public BookDTO getBook(String name) {
        try {
            return bookServiceClient.getBook(name);
        } catch (Exception e){
            // TODO implement
            log.warn("Unsupported operation");
            return null;
        }
    }

    public void rate(BookRatingDTO bookRatingDTO) {
        try {
            bookServiceClient.rate(bookRatingDTO);
        } catch (Exception e){
            // TODO implement
            log.warn("Unsupported operation");
        }
    }
}
