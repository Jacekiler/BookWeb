package com.jszarski.bookservice.service;

import com.jszarski.bookservice.model.entity.Book;
import com.jszarski.common.model.event.NotificationEvent;
import com.jszarski.common.model.event.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventBuilder {

    public NotificationEvent build(String email, Book book) {
        return NotificationEvent.builder()
                .email(email)
                .recommendation(buildRecommendation(book))
                .build();
    }

    private Recommendation buildRecommendation(Book book) {
        return Recommendation.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .ratingAvg(book.getRatingAvg())
                .build();
    }
}
