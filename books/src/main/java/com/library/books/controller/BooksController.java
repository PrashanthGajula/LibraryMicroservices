package com.library.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.dao.BooksDao;
import com.library.books.models.Book;
import com.library.books.models.Books;


@RestController
@RequestMapping("/books")
public class BooksController {
    
    @Autowired
    private BooksDao booksDao;

    @RequestMapping("/all")
    public Books getBooks(){
        List<Book> booksList = new ArrayList<>();
        for(Book book : booksDao.findAll()) {
        		booksList.add(book);
        }
        Books books = new Books(booksList);
        return books;
    }
    
    @RequestMapping("/addBook")
    public Book addBook(@RequestBody final Book book) {
    		return booksDao.save(book);
    }
    
    @RequestMapping("/searchBooks")
    public Books searchBooks(@RequestBody final Book book) {
    		List<Book> matchingBooks = booksDao.findBooksByName("%"+book.getBook_name()+"%");
    		return new Books(matchingBooks);
    }
}