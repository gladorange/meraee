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
	 *            the updated user information with new friends
	 * @param removedFriends
	 *            the list of old removed friends
	 * @return
	 */
	UserCard updateUser(UserCard userCard, List<UserCard> removedFriends);

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
	 *            the unique identifier of the user
	 * @return <code>null</code> will be returned if the user doesn't exist
	 */
	UserCard getUserById(Long id);

	/**
	 * Retrieves list of users which can be invited to friends list by the user
	 * with provided Id.
	 * 
	 * @param id
	 *            the unique identifier of the user
	 * @return
	 */
	List<UserCard> getPossibleFriends(Long id);

}
