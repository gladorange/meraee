package com.seprokof.usercard.service;

import java.util.List;

import com.seprokof.usercard.dao.UserCard;

/**
 * User service.
 * 
 * @author seprokof
 *
 */
public interface UserService {

	/**
	 * Insert new user.
	 * 
	 * @param userCard
	 *            the new user to add
	 * @throws Exception
	 */
	void addUser(UserCard userCard) throws Exception;

	/**
	 * Updates user data. Id is immutable.
	 * 
	 * @param userCard
	 *            the updated user information
	 */
	void updateUser(UserCard userCard);

	/**
	 * Removes user.
	 * 
	 * @param userCard
	 *            the user to remove
	 */
	void deleteUser(UserCard userCard);

	/**
	 * Retrieves list of existing users.
	 * 
	 * @return
	 */
	List<UserCard> getAllUsers();

	/**
	 * Retrieves user by Id.
	 * 
	 * @param id
	 *            the unique identifier of the user.
	 * @return <code>null</code> will be returned if the user doesn't exist
	 */
	UserCard getUserById(String id);

}
