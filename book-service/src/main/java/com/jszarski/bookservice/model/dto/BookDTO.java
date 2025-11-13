package com.jszarski.bookservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDTO {
    private String name;
    private String author;
    private String genre;
    private int rateCount;
    private Double avgRating;
}
