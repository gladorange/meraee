package controls;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UserDao;
import model.User;

@Named
@ApplicationScoped
public class UserManagementController {

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