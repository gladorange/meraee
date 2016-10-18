package org.arvios.jsfapps.manage;

import org.arvios.jsfapps.dao.User;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by artem-ostrovsky on 12.10.2016.
 */
@Named
@ApplicationScoped
public class UserManagementController implements Serializable {
    private static final long serialVersionUID = 9202273390567071088L;

    private Map<String, User> users = new ConcurrentHashMap<>();

    public UserManagementController() {
    }

    public void addOrUpdateUser(User user) {
        // if user with given ID does not exist, then add new user,
        // otherwise update existing user
        boolean userExists = users.containsKey(user.getId());
        users.put(user.getId(), user);
        if (userExists) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated, ID: " + user.getId(), null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "New user added, ID: " + user.getId(), null));
        }
    }

    public User getUserById(String id) {
        return users.get(id);
    }
}
