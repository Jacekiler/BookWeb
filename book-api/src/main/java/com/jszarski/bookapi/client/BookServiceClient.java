package com.jszarski.bookapi.client;

import com.jszarski.bookapi.model.dto.BookAddDTO;
import com.jszarski.bookapi.model.dto.BookDTO;
import com.jszarski.bookapi.model.dto.BookRatingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "book-service",
        url = "${book-service.url}"
)
public interface BookServiceClient {

    @GetMapping("/book/{name}")
    BookDTO getBook(@PathVariable("name") String name);

    @PostMapping("/book")
    BookDTO addBook(@RequestBody BookAddDTO bookAddDTO);

    @PostMapping("/book/rate")
    void rate(@RequestBody BookRatingDTO bookRatingDTO);
}
