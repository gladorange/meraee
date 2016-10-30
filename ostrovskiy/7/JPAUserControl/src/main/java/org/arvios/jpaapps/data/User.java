package org.arvios.jpaapps.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by artem-ostrovsky on 16.10.2016.
 */
@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "linkToPhoto")
    private String linkToPhoto;

    @OneToMany
    private Collection<User> friends;

    @ManyToMany
    @JoinTable(name = "User_Dish",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private Collection<Dish> favoriteDishes;

    public User() {
        friends = new ArrayList<User>();
        favoriteDishes = new ArrayList<Dish>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkToPhoto() {
        return linkToPhoto;
    }

    public void setLinkToPhoto(String linkToPhoto) {
        this.linkToPhoto = linkToPhoto;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }

    public Collection<Dish> getFavoriteDishes() {
        return favoriteDishes;
    }

    public void setFavoriteDishes(Collection<Dish> favoriteDishes) {
        this.favoriteDishes = favoriteDishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!password.equals(user.password)) return false;
        if (linkToPhoto != null ? !linkToPhoto.equals(user.linkToPhoto) : user.linkToPhoto != null) return false;
        if (friends != null ? !friends.equals(user.friends) : user.friends != null) return false;
        return favoriteDishes != null ? favoriteDishes.equals(user.favoriteDishes) : user.favoriteDishes == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (linkToPhoto != null ? linkToPhoto.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (favoriteDishes != null ? favoriteDishes.hashCode() : 0);
        return result;
    }
}
