package com.jszarski.bookapi.controller;

import com.jszarski.bookapi.model.dto.BookDTO;
import com.jszarski.bookapi.model.dto.BookRatingDTO;
import com.jszarski.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{name}")
    public BookDTO getBookByName(@PathVariable("name") String name) {
        return bookService.getBook(name);
    }

    @PostMapping
    public void rate(@RequestBody BookRatingDTO bookRatingDTO){
        bookService.rate(bookRatingDTO);
    }
}
