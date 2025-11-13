package com.jszarski.bookapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String name;
    private String author;
    private String genre;
    private int rateCount;
    private Double avgRating;
}
