package com.jszarski.common.model.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    private String name;
    private String author;
    private String genre;
    private Double ratingAvg;
}
