package com.library.books.controller;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
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
    	
//    		Book b1 = new Book(1, "demo Book name", "Demo Book Category");
//        List<Book> booksList =  new ArrayList<>();
//        booksList.add(b1);
//		Books books = new Books(booksList);
//        return books;

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
    		//Book savedBook = booksDao.save(book);
    		//return "Book ID: "+savedBook.getBook_id();
    }
    
    @RequestMapping("/searchBooks")
    public Books searchBooks(@RequestBody final Book book) {
    		
//    		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//    		Session session = factory.openSession();
//    		Transaction transaction = session.beginTransaction();
//    		
//    		transaction.begin();
//    		Query query = session.createQuery("from book where book_name = :bookName");
//    		query.setParameter("bookName", book.getBook_name());
//    		List list = query.list();
//    		
//    		transaction.commit();
//    		session.close();
//    		
//    		return (Book) list.get(0);
    		List<Book> matchingBooks = booksDao.findBooksByName("%"+book.getBook_name()+"%");
    		return new Books(matchingBooks);
    }
}