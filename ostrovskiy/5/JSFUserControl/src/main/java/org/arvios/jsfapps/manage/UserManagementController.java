package org.arvios.jsfapps.manage;

import org.arvios.jsfapps.dao.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    public void addUser(User user) throws Exception {
        if (users.containsKey(user.getId())) {
            throw new Exception("User with ID " + user.getId() + " already exists");
        }
        users.put(user.getId(), user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<User>(users.values());
    }
}
