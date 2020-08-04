package com.library.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.books.models.Book;

public interface BooksDao extends CrudRepository<Book, Integer>{
	
	/**
	 * Custom query to get the list of books matching the text bookName. 
	 * Reference: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
	 * @param bookName
	 * @return
	 */
	@Query("SELECT b FROM Book b WHERE b.book_name like ?1")
	List<Book> findBooksByName(final String bookName);
	
}
