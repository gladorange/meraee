package org.arvios.myapps.data;

import java.io.Serializable;

/**
 * Created by artem-ostrovsky on 13.11.2016.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 9143374916268579395L;

    private String id;
    private String name;
    private String surname;
    private String password;
    private String linkToPhoto;

    public User() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkToPhoto() {
        return this.linkToPhoto;
    }

    public void setLinkToPhoto(String linkToPhoto) {
        this.linkToPhoto = linkToPhoto;
    }

    public boolean hasPhoto() {
        return (linkToPhoto != null) && (!"".equals(linkToPhoto));
    }
}
