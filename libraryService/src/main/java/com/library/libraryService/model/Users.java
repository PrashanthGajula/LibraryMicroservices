package com.library.libraryService.model;

import java.util.List;

public class Users {
	private List<User> usersList;
	
	public Users() {
		
	}
	
	public Users(List<User> usersList) {
		this.usersList=usersList;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
}
