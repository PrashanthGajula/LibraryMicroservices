package com.library.users.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.users.models.User;

public interface UsersDao extends CrudRepository<User, Integer>{
	
	/**
	 * Custom query to get the list of Users in the list. 
	 * Reference: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
	 * @param commaSeparatedUserIds
	 * @return
	 */
	@Query("SELECT u FROM User u WHERE u.id IN ?1")
	List<User> findUsersById(final String commaSeparatedUserIds);

}
