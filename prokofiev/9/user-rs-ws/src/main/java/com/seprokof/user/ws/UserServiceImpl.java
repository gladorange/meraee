package com.seprokof.user.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.jws.WebService;

import com.seprokof.user.dao.User;

@WebService(targetNamespace = "http://ws.user.seprokof.com/", endpointInterface = "com.seprokof.user.ws.UserService", portName = "UserServiceImplPort", serviceName = "UserServiceImplService")
public class UserServiceImpl implements UserService {

	private Map<Long, User> database = new ConcurrentHashMap<>();

	public UserServiceImpl() {
		populateInitialValues();
	}

	private void populateInitialValues() {
		User u1 = new User(1L, "Tony", "Stark", "password", "http://b1.filmpro.ru/c/138600.660xp.jpg");
		database.put(u1.getId(), u1);

		User u2 = new User(2L, "Natalia", "Romanoff", "password",
				"http://vignette1.wikia.nocookie.net/marvelcinematicuniverse/images/e/e2/Widow_avengers.jpg/revision/latest?cb=20140317040028");
		database.put(u2.getId(), u2);
	}

	@Override
	public void addUser(User user) {
		if (user != null) {
			if (database.containsKey(user.getId())) {
				throw new RuntimeException("Unable to add user. User with the same Id already exist.");
			}
			database.put(user.getId(), user);
		}
	}

	@Override
	public User updateUser(User user) {
		if (user != null) {
			database.put(user.getId(), user);
		}
		return user;
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) {
			database.remove(user.getId());
		}
	}

	@Override
	public List<User> getAllUsers() {
		return new ArrayList<>(database.values());
	}

	@Override
	public User getUserById(Long id) {
		return database.get(id);
	}

}
