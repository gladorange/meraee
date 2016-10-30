package logic.dao;

import logic.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ansemen on 06.10.2016.
 */
@Named
@ApplicationScoped
public class UserDao {
    List<User> users = new CopyOnWriteArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findById(String userId) {
        return users.stream().filter(u -> u.getId().
                equals(Long.valueOf(userId))).findAny();
    }
}
