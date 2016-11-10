package com.seprokof.user.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.seprokof.user.dao.SecuredUser;
import com.seprokof.user.dao.User;
import com.seprokof.user.ws.UserService;

/**
 * REST resource for managing users.
 * 
 * @author seprokof
 *
 */
@Path("/user")
public class UserResource {
	private static final String SERVICE_URL = "http://localhost:8080/user-rs-ws/services/UserServiceImplPort";
	private static JaxWsProxyFactoryBean factory;
	static {
		factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(com.seprokof.user.ws.UserService.class);
		factory.setAddress(SERVICE_URL);
	}

	private final UserService userService;

	public UserResource() {
		this.userService = (UserService) factory.create();
	}

	/**
	 * Retrieves the list of all available users.
	 * 
	 * @return actual users or empty list if no users present in datastore
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SecuredUser> getAllUsers() {
		List<User> users = userService.getAllUsers();
		if (CollectionUtils.isNotEmpty(users)) {
			return users.stream().map(u -> new SecuredUser(u)).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	/**
	 * Retrieves information about single user by given id.
	 * 
	 * @param userId
	 *            the unique identifier of the user
	 * @return
	 *         <li>200 - safe-to-display user data</li>
	 *         <li>400 - if non-digit (bad) id specified</li>
	 *         <li>404 - if no user found with provided identifier</li>
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") String userId) {
		try {
			User ret = userService.getUserById(Long.valueOf(userId));
			if (ret == null) {
				return Response.status(Status.NOT_FOUND).build();
			}
			return Response.ok(new SecuredUser(ret)).build();
		} catch (NumberFormatException e) {
			throw new WebApplicationException("Id should be of type Long", Response.Status.BAD_REQUEST);
		}
	}

	/**
	 * Updates or add user information to the datastore.
	 * 
	 * @param user
	 *            the full json-represented user data
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		userService.updateUser(user);
		return Response.ok().build();
	}

	/**
	 * Removes user from the datastore.
	 * 
	 * @param user
	 *            the full json-represented user data
	 * @return
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(User user) {
		userService.deleteUser(user);
		return Response.ok().build();
	}

}
