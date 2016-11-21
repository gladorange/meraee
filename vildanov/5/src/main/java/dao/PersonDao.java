package dao;

import logic.User;

import java.util.List;

/**
 * Created by svildan on 25.10.2016.
 */
public interface PersonDao {
    void create(User user);
    User getUserById(Long userId);
    List<User> getUsers();
}
