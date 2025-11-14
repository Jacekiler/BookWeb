package com.jszarski.bookapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {
    private String genre;
    private Double avgRating;
    private String email;
    private SubscriptionType subscriptionType;
}

enum SubscriptionType {
    TOP_RATED,
    GENRE_NEW,
    TOP_RATED_GENRE
}
