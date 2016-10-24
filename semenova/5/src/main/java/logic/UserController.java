package logic;

import logic.dao.UserDao;
import logic.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

/**
 * Created by ansemen on 06.10.2016.
 */
@Named
@RequestScoped
public class UserController {
    @Inject
    UserDao userDao;

    User currentUser;
    String userId;

    public void setUserId(String id) {
        final Optional<User> byId = userDao.findById(id);
        if(byId.isPresent()) {
            currentUser = byId.get();
        }
        else {
            throw new IllegalArgumentException("User with id = " + id + " not found");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String getUserId() {
        return userId;
    }
}
