package com.library.books.models;

import java.util.List;

public class Books {
	private List<Book> booksList;
	
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
