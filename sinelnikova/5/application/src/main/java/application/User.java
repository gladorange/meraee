package application;


/**
 * Created by Viktoria on 05-Oct-16.
 */

public class User {
    private String id;
    private String firstName;
    private String secondName;
    private String password;
    private String fotoLink;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoLink() {
        return fotoLink;
    }

    public void setFotoLink(String fotoLink) {
        this.fotoLink = fotoLink;
    }

    @Override
    public String toString() {
        return "User{" + id +
                "," + firstName +
                "," + secondName +
                "," + password +
                "," + fotoLink +
                '}';
    }
}
