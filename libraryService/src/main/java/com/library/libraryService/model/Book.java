package com.library.libraryService.model;

public class Book {
	
	private int book_id;
	private String book_name;
	private String book_category;
	
	public Book() {
		
	}
	
	public Book(int book_id, String book_name, String book_category) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_category = book_category;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
}
