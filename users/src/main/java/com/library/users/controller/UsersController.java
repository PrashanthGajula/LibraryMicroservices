package com.library.users.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.users.dao.UsersDao;
import com.library.users.models.User;
import com.library.users.models.Users;

@RestController
@RequestMapping("/users")
public class UsersController {
	
    @Autowired
    private UsersDao userDao;
    
    @RequestMapping("/all")
    public Users getAllUsers() {
        List<User> usersList = new ArrayList<>();
        for(User user : userDao.findAll()) {
        		usersList.add(user);
        }
        
        Users users = new Users();
        users.setUsersList(usersList);
        return users;
    }
    
    @RequestMapping("/addUser")
    public User addUser(@RequestBody final User user) {
    		return userDao.save(user);
    }
    
    // URL -> /users/findUsers?ids=1,2,3,4,5...s
    @RequestMapping("/findUsers")
    public Users searchBooks(@RequestParam("ids") final List<Integer> userIds){
    	
    		List<User> userList = new ArrayList<>();
    		
    		for(User user : userDao.findAllById(userIds)) {
    			userList.add(user);
    		}
    		
	    return new Users(userList);
    }
}
