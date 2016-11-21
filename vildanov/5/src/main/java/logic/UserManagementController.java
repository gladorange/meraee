package logic;

import dao.PersonDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by svildan on 15.11.2016.
 */
@Named
@ApplicationScoped
public class UserManagementController {
    User currentUser = new User();

    @Inject
    PersonDao personDao;


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getUsersList() {
        if (null!=personDao.getUsers()) {
            return personDao.getUsers();
        }
        return null;
    }

    public String saveUser() {
        personDao.create(currentUser);
        currentUser = new User();
        return "";
    }
}
