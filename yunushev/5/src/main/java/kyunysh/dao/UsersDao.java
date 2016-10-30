package kyunysh.dao;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import kyunysh.User;

@Named
@ApplicationScoped
public class UsersDao implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final Map<String, User> usersMap = new HashMap<String, User>();

	public UsersDao() {
		final User user = new User();
		user.setId("1");
		user.setFirstName("first name");
		user.setSecondName("second name");
		user.setPassword("pass");
		try {
			user.setPhotoUrl(new URL("http://mirgif.com/humor/prikol104.jpg"));
		} catch (final MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usersMap.put(user.getId(), user);
	}

	public void addUser(final User user) {
		usersMap.put(user.getId(), user);
	}

	public void removeUser(final String id) {
		usersMap.remove(id);
	}

	public User getUser(final String id) {
		return usersMap.get(id);
	}

	public Collection<User> getUsers() {
		return usersMap.values();
	}
}
