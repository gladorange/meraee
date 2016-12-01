package controls;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UserDao;
import model.User;

@Named
@RequestScoped
public class UserController {

    @Inject
    UserDao userDao;
    User currentUser;
    String userId;

    public void setUserId(String id) {
        final Optional<User> byId = userDao.findById(id);
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
