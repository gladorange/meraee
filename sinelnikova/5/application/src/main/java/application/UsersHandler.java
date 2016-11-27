package application;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Viktoria on 05-Oct-16.
 */
@Named
@RequestScoped
public class UsersHandler implements Serializable{
    private User user;
    private String userId;

    @Inject
    UserData userData;

    public UsersHandler() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        userId = id;
        if (userData.findUser(id) != null) {
            user = userData.findUser(id);
        } else {
            throw new IllegalArgumentException("User's Id not found, try again.");
        }
    }
}
