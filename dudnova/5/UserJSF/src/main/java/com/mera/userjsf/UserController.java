package com.mera.userjsf;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserController {
	@Inject
    UserList userList;
    User currentUser;
    String userId;

    public void setUserId(String id) {
        userId = id;
        final Optional<User> byId = userList.findById(id);
        if (byId.isPresent()) {
            currentUser = byId.get();
        } else {
            throw new IllegalArgumentException("id not found");
        }

    }

    public String getUserId() {
        return userId;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
