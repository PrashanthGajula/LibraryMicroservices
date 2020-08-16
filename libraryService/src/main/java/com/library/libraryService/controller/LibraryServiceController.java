package com.library.libraryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.library.libraryService.model.Book;
import com.library.libraryService.model.Books;
import com.library.libraryService.model.Checkout;
import com.library.libraryService.model.CheckoutList;
import com.library.libraryService.model.User;
import com.library.libraryService.model.Users;

@RestController
@RequestMapping("/library")
public class LibraryServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////              Book Services              /////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
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
	
    // URL -> /books/searchBooks?searchText=TeluguBook
	@RequestMapping("/searchBooks")
	public List<Book> searchBooks(@RequestParam("searchText") final String searchText){
		String url = "http://books-service/books/searchBooks?searchText="+searchText;
		final Books books = restTemplate.getForObject(url, Books.class);
		return books.getBooksList();
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////              User Services              /////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/allUsers")
	public List<User> getUsers(){
		final Users users = restTemplate.getForObject("http://users-service/users/all", Users.class);
		return users.getUsersList();
	}
	
	@RequestMapping("/addUser")
	public User addUser(@RequestBody final User user) {
		final User addedUser = restTemplate.postForObject("http://users-service/users/addUser", user, User.class);
		return addedUser;
	}
	
    // URL -> /library/findUsers?ids=1,2,3,4,5...s
    @RequestMapping("/findUsers")
    public List<User> searchBooks(@RequestParam("ids") final List<Integer> userIds){
    		
    		String uri = ""; 
    		for(Integer userId : userIds) {	
    			uri= uri + ", " + userId;
    		}
    		uri = uri.substring(2);
    		
    		String masteruri = "http://users-service/users/findUsers?ids="+uri;
    		final Users users = restTemplate.getForObject(masteruri, Users.class);
    		return users.getUsersList();
    }
    
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////            Checkout Services            /////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/allCheckouts")
	public List<Checkout> getCheckouts(){
		final CheckoutList checkoutList = restTemplate.getForObject("http://checkout-service/checkout/all", CheckoutList.class);
		return checkoutList.getCheckoutList();
	}
	
    @RequestMapping("/checkoutBook")
    public Checkout checkoutBooktoUser(@RequestBody final Checkout checkout) {
    		final Checkout checkoutBook = restTemplate.postForObject("http://checkout-service/checkout/book", checkout, Checkout.class);
    		return checkoutBook;
    }
    
    //Find all the books checked out by user.
    @RequestMapping("/GetUserCheckedoutBooks/{userId}")
    public List<Book> getBooksCheckedoutByUser(@PathVariable("userId") final Integer userId){
    		final CheckoutList checkoutList = restTemplate.getForObject("http://checkout-service/checkout/CheckoutsByUser?userid="+userId, CheckoutList.class);
    		
    		String url = "";
    		
    		for(Checkout checkout : checkoutList.getCheckoutList()) {
    			url=url + ", " + checkout.getBookid();
    		}
    		url = url.substring(2);
    		
    		final Books books = restTemplate.getForObject("http://books-service/books/findBooks?ids=" + url, Books.class);
    		return books.getBooksList();
    }
}
