package evilorange.dao;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import evilorange.model.User;


@Named
@ApplicationScoped
public class UserDao {
    List<User> users = new CopyOnWriteArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findById(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findAny();
    }

    public List<User> getUsers() {
        return users;
    }
}
