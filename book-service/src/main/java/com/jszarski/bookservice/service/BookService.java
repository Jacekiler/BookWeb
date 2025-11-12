package com.jszarski.bookservice.service;

import com.jszarski.bookservice.model.dto.BookDTO;
import com.jszarski.bookservice.model.dto.BookRatingDTO;
import com.jszarski.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Optional<BookDTO> getBook(String name) {
        // todo
        return Optional.empty();
    }

    public void rate(BookRatingDTO bookRatingDTO) {
        // todo
    }
}
