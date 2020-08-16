package com.library.checkout.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.checkout.models.Checkout;

public interface CheckoutDao extends CrudRepository<Checkout, Integer>{
	
	/**
	 * Custom query to get the list of books(checkout objects) checked out by a user.
	 * Reference: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
	 * @param userId
	 * @return
	 */
	@Query("SELECT c FROM Checkout c WHERE c.userid = ?1")
	List<Checkout> findBooksCheckedOutByUserId(final Integer	userId);
	
	/**
	 * Custom query to get the List of Users(checkout objects) who checked out a book.
	 * Reference: https://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
	 * @param bookId
	 * @return
	 */
	@Query("SELECT c FROM Checkout c WHERE c.bookid = ?1")
	List<Checkout> findUsersCheckedOutABook(final Integer	 bookId);
}
