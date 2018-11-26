package com.codingdojo.springmysql.repositories;

import com.codingdojo.springmysql.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    void deleteById(Long id);
    List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
