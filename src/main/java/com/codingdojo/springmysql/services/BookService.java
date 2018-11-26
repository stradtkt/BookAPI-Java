package com.codingdojo.springmysql.services;

import com.codingdojo.springmysql.models.Book;
import com.codingdojo.springmysql.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
//
//    public Book updateBook(Long id, Book book) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//
//    }
}
