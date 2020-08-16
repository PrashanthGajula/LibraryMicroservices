package com.library.checkout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.checkout.dao.CheckoutDao;
import com.library.checkout.models.Checkout;
import com.library.checkout.models.CheckoutList;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutDao checkoutDao;
    
    @RequestMapping("/all")
    public CheckoutList getCheckouts(){
        List<Checkout> checkoutList = new ArrayList<>();
        for(Checkout checkout : checkoutDao.findAll()) {
        		checkoutList.add(checkout);
        }
        CheckoutList checkoutList2 = new CheckoutList(checkoutList);
        return checkoutList2;
    }
    
    @RequestMapping("/book")
    public Checkout checkoutBook(@RequestBody final Checkout checkout) {
    		return checkoutDao.save(checkout);
    }
    
    // URL -> /checkout/CheckoutsByUser?userid=37
    @RequestMapping("/CheckoutsByUser")
    public CheckoutList getBooksByUserId(@RequestParam("userid") final Integer userId){
	    List<Checkout> booksCheckedOut = checkoutDao.findBooksCheckedOutByUserId(userId);
	    return new CheckoutList(booksCheckedOut);
    }
    
    // URL -> /checkout/CheckoutsByBook?bookid=22
    @RequestMapping("/CheckoutsByBook")
    public CheckoutList getUsersByBookId(@RequestParam("bookid") final Integer bookId){
	    List<Checkout> booksCheckedOut = checkoutDao.findUsersCheckedOutABook(bookId);
	    return new CheckoutList(booksCheckedOut);
    }   
}
