package logic;

import dao.PersonDao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by svildan on 24.10.2016.
 */
@Named
@RequestScoped
public class UserController {
    @Inject
    private PersonDao personDao;
    private User currentUser;
    private String userId;

    public void setUserId(String id) {
        userId = id;
        final User user = personDao.getUserById(Long.parseLong(id));
        if (null != user) {
            currentUser = user;
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
