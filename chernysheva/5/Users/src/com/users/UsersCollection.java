package com.users;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="usersCollection")
@SessionScoped
public class UsersCollection {
	@ManagedProperty(value="#{userBean}")
    UserBean currentUser;
	
	HashMap<Integer, UserBean> usersMap;

	public UsersCollection() {
		this.usersMap = new HashMap<Integer, UserBean>();
	}
	
	public void AddUser() {
		try {
		    if (null != currentUser) {
		    	currentUser.generateId();
		    	UserBean user = new UserBean(currentUser.getId(), currentUser.getName(), 
		    	    currentUser.getSecondName(), currentUser.getPassword(), currentUser.getPhotoLink());
		    	usersMap.put((Integer)user.getId(), user);
		    }  
		}
		catch (Exception ex) {			
		// nothing   
		}
	}
	
	public void removeUser() {
		try {
		    if (null != currentUser) {
		    	usersMap.remove(currentUser.getId());
		    }
		}
		catch (Exception ex) {			
        // nothing  
		}
	}
	
	public UserBean getUser() {
		try {
			String id = FacesContext.getCurrentInstance().getExternalContext().
				getRequestParameterMap().get("id");

			int parsedId = Integer.parseInt(id);
		    return usersMap.get(parsedId);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public UserBean getCurrenUser() {
		return currentUser;
	}
		
    public void setCurrentUser(UserBean ub) {
    	this.currentUser = ub;
    }
	
	public HashMap<Integer, UserBean> getUsersMap() {
		return usersMap;
	}
	
	public void setUsersMap(HashMap<Integer, UserBean> hm) {
		usersMap = hm;
	}
}
