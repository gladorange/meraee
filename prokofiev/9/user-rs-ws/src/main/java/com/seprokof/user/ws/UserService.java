
package com.seprokof.user.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.seprokof.user.dao.User;

@WebService(name = "UserService", targetNamespace = "http://ws.user.seprokof.com/")
public interface UserService {

	/**
	 * Insert new user.
	 * 
	 * @param user
	 *            the new user to add
	 * @throws Exception
	 */
	@WebMethod(operationName = "addUser", action = "urn:AddUser")
	@RequestWrapper(className = "com.seprokof.user.ws.jaxws.AddUser", localName = "addUser", targetNamespace = "http://ws.user.seprokof.com/")
	@ResponseWrapper(className = "com.seprokof.user.ws.jaxws.AddUserResponse", localName = "addUserResponse", targetNamespace = "http://ws.user.seprokof.com/")
	@WebResult(name = "return")
	void addUser(@WebParam(name = "arg0") User user) throws Exception;

	/**
	 * Updates user data. Id is immutable.
	 * 
	 * @param user
	 *            the updated user information with new friends
	 * @return
	 */
	@WebMethod(operationName = "updateUser", action = "urn:UpdateUser")
	@RequestWrapper(className = "com.seprokof.user.ws.jaxws.UpdateUser", localName = "updateUser", targetNamespace = "http://ws.user.seprokof.com/")
	@ResponseWrapper(className = "com.seprokof.user.ws.jaxws.UpdateUserResponse", localName = "updateUserResponse", targetNamespace = "http://ws.user.seprokof.com/")
	@WebResult(name = "return")
	User updateUser(@WebParam(name = "arg0") User user);

	/**
	 * Removes user.
	 * 
	 * @param user
	 *            the user to remove
	 */
	@WebMethod(operationName = "deleteUser", action = "urn:DeleteUser")
	@RequestWrapper(className = "com.seprokof.user.ws.jaxws.DeleteUser", localName = "deleteUser", targetNamespace = "http://ws.user.seprokof.com/")
	@ResponseWrapper(className = "com.seprokof.user.ws.jaxws.DeleteUserResponse", localName = "deleteUserResponse", targetNamespace = "http://ws.user.seprokof.com/")
	@WebResult(name = "return")
	void deleteUser(@WebParam(name = "arg0") User user);

	/**
	 * Retrieves list of existing users.
	 * 
	 * @return
	 */
	@WebMethod(operationName = "getAllUsers", action = "urn:GetAllUsers")
	@RequestWrapper(className = "com.seprokof.user.ws.jaxws.GetAllUsers", localName = "getAllUsers", targetNamespace = "http://ws.user.seprokof.com/")
	@ResponseWrapper(className = "com.seprokof.user.ws.jaxws.GetAllUsersResponse", localName = "getAllUsersResponse", targetNamespace = "http://ws.user.seprokof.com/")
	@WebResult(name = "return")
	List<User> getAllUsers();

	/**
	 * Retrieves user by Id.
	 * 
	 * @param id
	 *            the unique identifier of the user
	 * @return <code>null</code> will be returned if the user doesn't exist
	 */
	@WebMethod(operationName = "getUserById", action = "urn:GetUserById")
	@RequestWrapper(className = "com.seprokof.user.ws.jaxws.GetUserById", localName = "getUserById", targetNamespace = "http://ws.user.seprokof.com/")
	@ResponseWrapper(className = "com.seprokof.user.ws.jaxws.GetUserByIdResponse", localName = "getUserByIdResponse", targetNamespace = "http://ws.user.seprokof.com/")
	@WebResult(name = "return")
	User getUserById(@WebParam(name = "arg0") Long id);

}
