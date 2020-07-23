package com.library.libraryService.model;

public class Book {
	
	private int bookId;
	private String bookName;
	private String bookCategory;
	
	public Book() {
	
	}
	
	public Book(int bookId, String bookName, String bookCategory) {
		this.bookId=bookId;
		this.bookName=bookName;
		this.bookCategory=bookCategory;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
}
