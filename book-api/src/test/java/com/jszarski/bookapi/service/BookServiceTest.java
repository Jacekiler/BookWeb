package com.jszarski.bookapi.service;

import com.jszarski.bookapi.client.BookServiceClient;
import com.jszarski.common.model.dto.BookAddDTO;
import com.jszarski.common.model.dto.BookDTO;
import com.jszarski.common.model.dto.BookRatingDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookServiceClient client;

    @InjectMocks
    private BookService service;

    @Test
    public void getBook() {
        //given
        String name = "name";
        var returned = new BookDTO();
        when(client.getBooks(name)).thenReturn(List.of(returned));

        //when
        var result = service.getBooks(name);

        //then
        verify(client, times(1)).getBooks(name);
        assertEquals(1, result.size());
        assertEquals(returned, result.get(0));
    }

    @Test
    public void addBook() {
        //given
        BookAddDTO bookAddDTO = new BookAddDTO();
        var added = new BookDTO();
        when(client.addBook(bookAddDTO)).thenReturn(added);

        //when
        var result = service.addBook(bookAddDTO);

        //then
        verify(client, times(1)).addBook(bookAddDTO);
        assertEquals(added, result);
    }

    @Test
    public void deleteBook() {
        //given
        UUID id = UUID.randomUUID();

        //when
        service.deleteBook(id);

        //then
        verify(client, times(1)).deleteBook(id);
    }

    @Test
    public void rate() {
        //given
        BookRatingDTO bookRatingDTO = new BookRatingDTO();

        //when
        service.rate(bookRatingDTO);

        //then
        verify(client, times(1)).rate(bookRatingDTO);
    }
}