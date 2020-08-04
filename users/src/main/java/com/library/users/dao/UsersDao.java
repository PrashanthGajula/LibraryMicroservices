package com.library.users.dao;

import org.springframework.data.repository.CrudRepository;

import com.library.users.models.User;

public interface UsersDao extends CrudRepository<User, Integer>{

}
