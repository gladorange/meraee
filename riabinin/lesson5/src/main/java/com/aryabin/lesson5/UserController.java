package com.aryabin.lesson5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class UserController implements Serializable {
	
	private List<User> users = new ArrayList<User>();

	public UserController() {
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void saveUser(User user) {
		if (!users.contains(user))
			users.add(user);
	}
	
	public User getUser(String id) {
		Predicate<User> predicate = u->u.getID().equals(id);
		User user = users.stream().filter(predicate).findFirst().get();
		return user;
	}
}
