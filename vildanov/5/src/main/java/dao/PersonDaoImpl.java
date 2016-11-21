package dao;

import logic.User;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by svildan on 25.10.2016.
 */
@Named
@ApplicationScoped
public class PersonDaoImpl implements PersonDao {
    private Map<Long,User> users = new HashMap<Long, User>();
    public void create(User user) {
        users.put(user.getId(),user);
    }

    public User getUserById(Long userId) {
        return users.get(userId);
    }

    public List<User> getUsers() {
       return users.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }
}
