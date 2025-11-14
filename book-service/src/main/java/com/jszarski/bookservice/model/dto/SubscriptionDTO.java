package com.jszarski.bookservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {
    private String genre;
    private Double avgRating;
    private String email;
    private List<SubscriptionType> subscriptionTypes;
}

enum SubscriptionType {
    TOP_RATED,
    GENRE_NEW,
    TOP_RATED_GENRE
}
