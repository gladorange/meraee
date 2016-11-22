package com.users;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name="userBean")
@RequestScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static AtomicInteger at = new AtomicInteger(0);
	
	private int id;
	private String name;
	private String secondName;
	private String password;
	private String photoLink;
	
	public UserBean() {
		
	}

	public UserBean(int id, String name, String secondName, String password, 
			        String photoLink) {
	    this.id = id;	
	    this.name = name;
	    this.secondName = secondName;
	    this.password = password;
	    this.photoLink = photoLink;
	}	
	
	public void generateId() {
		this.id = at.incrementAndGet();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhotoLink() {
		return photoLink;
	}
	
	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}
	
	public String clearValues() {
		id = 0;
		name = null;
		secondName = null;
		password = null;
		photoLink = null;
		return "AddUser";
	}
	
	public String isPhotoSet() {
		return this.photoLink.length() == 0 ? "true" : "false";
	}
	
}

