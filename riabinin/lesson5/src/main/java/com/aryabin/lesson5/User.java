package com.aryabin.lesson5;

import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@RequestScoped
public class User {
	
	@ManagedProperty(value = "#{userController}")
	private UserController userController;
	
	private String ID;
	private String firstName;
	private String lastName;
	private String password;
	private String photoUri;
	
	public User() {
		this.ID = UUID.randomUUID().toString();
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String id) {
		ID = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhotoUri() {
		return photoUri;
	}
	
	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}
	
	public void init(ComponentSystemEvent event) {
		User user = userController.getUser(this.ID);
		if (user != null) {
			this.firstName = user.firstName;
			this.lastName = user.lastName;
			this.password = user.password;
			this.photoUri = user.photoUri;
		}
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
}
