package com.codingdojo.springmysql.controllers;

import com.codingdojo.springmysql.models.Book;
import com.codingdojo.springmysql.services.BookService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
public class BooksApi {
    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> index() {
        return bookService.allBooks();
    }
    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
                       @RequestParam(value = "language") String lang, @RequestParam(value = "numberOfPages") Integer pages) {
        Book book = new Book(title, desc, lang, pages);
        return bookService.createBook(book);
    }
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
//    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
//    public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
//                       @RequestParam(value = "language") String lang, @RequestParam(value = "numberOfPages") Integer pages) {
//        Book book = bookService.updateBook(id, title, desc, lang, pages);
//        return book;
//    }
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
