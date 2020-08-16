package com.library.checkout.models;

import java.util.List;

public class CheckoutList {
	private List<Checkout> checkoutList;
	
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
