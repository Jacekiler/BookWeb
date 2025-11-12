package com.jszarski.bookservice.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Book {

    private UUID id;
    private String name;
    private String author;
    private double ratingSum;
    private int ratingCount;
}
