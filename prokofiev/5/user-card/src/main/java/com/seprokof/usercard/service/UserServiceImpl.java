package com.seprokof.usercard.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.seprokof.usercard.dao.UserCard;

@ManagedBean(name = "userService", eager = true)
@ApplicationScoped
public class UserServiceImpl implements UserService, Serializable {
	private static final long serialVersionUID = -2665687359261559140L;

	private Map<String, UserCard> users = new ConcurrentHashMap<String, UserCard>();

	public UserServiceImpl() {
		addDummyUsers();
	}

	@Override
	public void addUser(UserCard userCard) throws Exception {
		if (users.containsKey(userCard.getId())) {
			throw new Exception("User with the Id " + userCard.getId() + " already exist");
		}
		users.put(userCard.getId(), userCard);
	}

	@Override
	public void updateUser(UserCard userCard) {
		users.put(userCard.getId(), userCard);
	}

	@Override
	public void deleteUser(UserCard userCard) {
		users.remove(userCard.getId());
	}

	@Override
	public List<UserCard> getAllUsers() {
		return new ArrayList<UserCard>(users.values());
	}

	@Override
	public UserCard getUserById(String id) {
		return users.get(id);
	}

	private void addDummyUsers() {
		UserCard u1 = new UserCard();
		u1.setId("1111");
		u1.setFirstName("Tony");
		u1.setLastName("Stark");
		u1.setPictureLink("http://b1.filmpro.ru/c/138600.660xp.jpg");
		users.put("1111", u1);

		UserCard u2 = new UserCard();
		u2.setId("2222");
		u2.setFirstName("Natalia");
		u2.setLastName("Romanoff");
		u2.setPictureLink(
				"http://vignette1.wikia.nocookie.net/marvelcinematicuniverse/images/e/e2/Widow_avengers.jpg/revision/latest?cb=20140317040028");
		users.put("2222", u2);
	}

}
