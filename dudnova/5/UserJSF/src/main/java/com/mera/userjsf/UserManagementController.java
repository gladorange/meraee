package com.mera.userjsf;

import java.util.Collection;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserManagementController {
	User currentUser = new User();

    @Inject
    UserList userList;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String addUser() {
    	userList.addUser(currentUser);
        currentUser = new User();
        return "";
    }

    public Collection<User> getAllUsers() {
        return userList.getUsers();
    }
}
