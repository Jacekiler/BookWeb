package com.jszarski.bookservice.repository;

import com.jszarski.bookservice.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findByName(String name);

    Optional<Book> findByNameAndAuthor(String name, String author);

    boolean existsByNameAndAuthor(String name, String author);
}
