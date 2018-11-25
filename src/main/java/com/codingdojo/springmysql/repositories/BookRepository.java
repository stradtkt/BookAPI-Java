package com.codingdojo.springmysql.repositories;

import com.codingdojo.springmysql.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
