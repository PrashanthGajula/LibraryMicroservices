package com.library.libraryService.model;

import java.sql.Date;

public class Checkout {

	private int checkoutid;
	private int bookid;
	private int userid;
	private Date checkoutdate;
	
	Checkout(){
		
	}
	
	public Checkout(int checkoutid, int bookid, int userid, Date checkoutdate) {
		this.checkoutid=checkoutid;
		this.bookid=bookid;
		this.userid=userid;
		this.setCheckoutdate(checkoutdate);
	}
	
	public int getCheckoutid() {
		return checkoutid;
	}
	public void setCheckoutid(int checkoutid) {
		this.checkoutid = checkoutid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
}
