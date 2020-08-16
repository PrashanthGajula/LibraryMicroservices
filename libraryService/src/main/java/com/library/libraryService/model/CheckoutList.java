package com.library.libraryService.model;

import java.util.List;

public class CheckoutList {
	private List<Checkout> checkoutList;
	
	CheckoutList(){
		
	}
	
	public CheckoutList(List<Checkout> checkoutList) {
		this.setCheckoutList(checkoutList);
	}

	public List<Checkout> getCheckoutList() {
		return checkoutList;
	}

	public void setCheckoutList(List<Checkout> checkoutList) {
		this.checkoutList = checkoutList;
	}
}
