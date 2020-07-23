package com.library.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.models.Book;
import com.library.books.models.Books;


@RestController
@RequestMapping("/books")
public class BooksController {
    
//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/all")
    public Books getBooks(){
    		Book b1 = new Book(1, "demo Book name", "Demo Book Category");
    	
        List<Book> booksList =  new ArrayList<>();
        booksList.add(b1);
        
		Books books = new Books(booksList);
		
        return books;
    }
}