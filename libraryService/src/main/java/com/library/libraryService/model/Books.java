package com.library.libraryService.model;

import java.util.List;

public class Books {
	private List<Book> booksList;
	
	public Books() {
		
	}
	
	public Books(List<Book> booksList) {
		this.booksList=booksList;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

}
