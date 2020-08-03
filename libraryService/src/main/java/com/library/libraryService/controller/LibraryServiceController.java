package com.library.libraryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.library.libraryService.model.Book;
import com.library.libraryService.model.Books;

@RestController
@RequestMapping("/library")
public class LibraryServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/allBooks")
	public List<Book> getBooks(){
		
		//To use books-service in the url , make sure to add @LoadBalanced to the restTemplate.
		final Books books = restTemplate.getForObject("http://books-service/books/all", Books.class);
        return books.getBooksList();
	}
	
	@RequestMapping("/addBook")
	public Book addBook(@RequestBody final Book book) {
		
		final Book addedBook = restTemplate.postForObject("http://books-service/books/addBook", book, Book.class);
		return addedBook;
	}
}
