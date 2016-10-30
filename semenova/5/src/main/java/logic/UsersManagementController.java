package logic;

import logic.dao.UserDao;
import logic.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

/**
 * Created by ansemen on 06.10.2016.
 */
@Named
@ApplicationScoped
public class UsersManagementController {

    User currentUser = new User();

    @Inject
    UserDao userDao;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String addUser() {
        userDao.addUser(currentUser);
        currentUser = new User();
        return "";
    }

    public Collection<User> getAllUsers() {
        return userDao.getUsers();
    }
}
