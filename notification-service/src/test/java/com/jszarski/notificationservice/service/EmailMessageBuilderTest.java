package com.jszarski.notificationservice.service;

import com.jszarski.common.model.event.NotificationEvent;
import com.jszarski.common.model.event.Recommendation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailMessageBuilderTest {

    private static final String EMAIL = "my@email.com";
    private static final String NAME = "Harry Potter";
    private static final String GENRE = "Fantasy";
    private static final String AUTHOR = "J.R.R. Tolkien";
    private static final Double RATING = 7.0;

    private final EmailMessageBuilder builder = new EmailMessageBuilder();

    @Test
    public void newMessage(){
        //given
        var event = NotificationEvent.builder()
                .email(EMAIL)
                .recommendation(Recommendation.builder()
                        .genre(GENRE)
                        .name(NAME)
                        .author(AUTHOR)
                        .ratingAvg(null)
                        .build())
                .build();

        //when
        var result = builder.newRecommendationMessage(event);

        //then
        var expected = """
            Title: Harry Potter
            Author: J.R.R. Tolkien
            Genre: Fantasy
            """;
        assertAll(
                () -> assertEquals("New book recommendation", result.getSubject()),
                () -> assertEquals(1, result.getTo().length),
                () -> assertEquals(EMAIL, result.getTo()[0]),
                () -> assertEquals(expected, result.getText())
        );
    }

    @Test
    public void popularMessage(){
        //given
        var event = NotificationEvent.builder()
                .email(EMAIL)
                .recommendation(Recommendation.builder()
                        .genre(GENRE)
                        .name(NAME)
                        .author(AUTHOR)
                        .ratingAvg(RATING)
                        .build())
                .build();

        //when
        var result = builder.popularRecommendationMessage(event);

        //then
        var expected = """
            Title: Harry Potter
            Author: J.R.R. Tolkien
            Genre: Fantasy
            Rating: 7.0
            """;
        assertAll(
                () -> assertEquals("Popular book recommendation", result.getSubject()),
                () -> assertEquals(1, result.getTo().length),
                () -> assertEquals(EMAIL, result.getTo()[0]),
                () -> assertEquals(expected, result.getText())
        );
    }
}