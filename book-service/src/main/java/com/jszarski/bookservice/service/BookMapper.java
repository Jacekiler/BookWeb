package com.jszarski.bookservice.service;

import com.jszarski.bookservice.model.dto.BookDTO;
import com.jszarski.bookservice.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO toDto(Book book) {
        return BookDTO.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .avgRating(book.getRatingAvg())
                .rateCount(book.getRatingCount())
                .build();
    }
}
