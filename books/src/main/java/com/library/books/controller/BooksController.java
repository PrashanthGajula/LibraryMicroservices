package com.library.books.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping("/deleteBook/{bookId}")
    public boolean deleteBook(@PathVariable("bookId") final int bookId) {
    		booksDao.deleteById(bookId);
    		Optional<Book> book = booksDao.findById(bookId);
    		return !book.isPresent();//to indicate book by bookId is not present after deletion.
    }
    
    // URL -> /books/searchBooks?searchText=TeluguBook
    @RequestMapping("/searchBooks")
    public Books searchBooks(@RequestParam("searchText") final String searchText){
	    List<Book> matchingBooks = booksDao.findBooksByName("%"+ searchText +"%");
	    return new Books(matchingBooks);
    }
	
    @RequestMapping("/updateBook/{bookId}")
    public Book updateBook(@PathVariable("bookId") final int bookId, @RequestBody final Book book) {	
        if(booksDao.existsById(bookId)) {
            book.setBook_id(bookId);
            return booksDao.save(book);
        }
        return null;
    }
    
    // URL -> /books/findBooks?ids=1,2,3,4,5...s
    @RequestMapping("/findBooks")
    public Books findBooksByID(@RequestParam("ids") final List<Integer> bookIds){
    	
    		List<Book> bookList = new ArrayList<>();
    		
    		for(Book book : booksDao.findAllById(bookIds)) {
    			bookList.add(book);
    		}
    		
	    return new Books(bookList);
    }
}