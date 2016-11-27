package application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktoria on 05-Oct-16.
 */
@Named
@ApplicationScoped
public class UserData {
    private List<User> users = new ArrayList<>();

    public UserData() {
        addFirst();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User u){
        users.add(u);
    }

    public User findUser(String id) {
        for (User u : users) {
            if(id.equals(u.getId())){
                return u;
            }
        }
        return null;
    }

    public void addFirst(){
        User userTest = new User();
        userTest.setId("1");
        userTest.setFirstName("Fill");
        userTest.setSecondName("Adm");
        userTest.setPassword("kit");
        userTest.setFotoLink("http://krevetot.net/wp-content/uploads/2016/05/cat_1464053753.jpg");
        users.add(userTest);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "users=" + users +
                '}';
    }
}
