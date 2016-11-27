package application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Viktoria on 05-Oct-16.
 */
@Named
@ApplicationScoped
public class ViewHandler implements Serializable {
    private User user = new User();

    @Inject
    UserData userData;

    public ViewHandler() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(){
        userData.addUser(user);
        user = new User();
    }

    public List<User> getUsers(){
        return userData.getUsers();
    }

    public String getUserData() {
        return userData.toString();
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
