package org.arvios.jpaapps.persist;

import org.arvios.jpaapps.data.Dish;
import org.arvios.jpaapps.data.User;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by artem-ostrovsky on 19.10.2016.
 */
@Named
@ApplicationScoped
public class PersistenceController {
    @PersistenceContext(unitName = "arviosDBUnit")
    EntityManager em;

    private String currentId;
    private User currentUser;

    // for friend to add
    private String currentFriendId;

    // for favorite dish to add
    private String currentFavoriteDishId;

    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser() {
        StringBuffer queryBuf = new StringBuffer("SELECT u FROM User AS u WHERE id='");
        queryBuf.append(currentId).append("'");
        final Query query = em.createQuery(queryBuf.toString());
        List<User> userList = query.getResultList();
        currentUser = userList.get(0);
    }

    public String getCurrentFriendId() {
        return currentFriendId;
    }

    public void setCurrentFriendId(String currentFriendId) {
        this.currentFriendId = currentFriendId;
    }

    public String getCurrentFavoriteDishId() {
        return currentFavoriteDishId;
    }

    public void setCurrentFavoriteDishId(String currentFavoriteDishId) {
        this.currentFavoriteDishId = currentFavoriteDishId;
    }

    private User getUserById(String id) {
        StringBuffer queryBuf = new StringBuffer("SELECT u FROM User AS u WHERE id = '");
        queryBuf.append(id).append("'");
        Query query = em.createQuery(queryBuf.toString());
        List<User> userList = query.getResultList();
        return (userList.isEmpty() ? null : userList.get(0));
    }

    public void addOrUpdateUser(User user) {
        em.getTransaction().begin();

        // if user with given ID does not exist, then add new user,
        // otherwise update existing user
        User userInDB = getUserById(user.getId());
        em.persist(user);
        em.getTransaction().commit();
        if (userInDB != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated, ID: " + user.getId(), null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "New user added, ID: " + user.getId(), null));
        }

        currentId = user.getId();
        currentUser = user;
    }

    public void addFriendForCurrentUser() {
        User friendInDB = getUserById(currentFriendId);
        if (friendInDB == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User with ID " + currentFriendId + " does not exist", null));
        } else {
            if (currentUser.getFriends().contains(friendInDB)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User with ID " + currentFriendId + " is already in friend list for user with ID " + currentId, null));
            } else {
                em.getTransaction().begin();
                currentUser.getFriends().add(friendInDB);
                em.persist(currentUser);
                if (!friendInDB.getFriends().contains(currentUser)) {
                    friendInDB.getFriends().add(currentUser);
                    em.persist(friendInDB);
                }
                em.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User with ID " + currentFriendId + " added to friend list for user with ID " + currentId, null));
            }
        }
    }

    private Dish getDishById(String id) {
        StringBuffer queryBuf = new StringBuffer("SELECT d FROM Dish AS d WHERE id = '");
        queryBuf.append(id).append("'");
        Query query = em.createQuery(queryBuf.toString());
        List<Dish> dishList = query.getResultList();
        return (dishList.isEmpty() ? null : dishList.get(0));
    }

    public void addFavoriteDishForCurrentUser() {
        Dish dishInDB = getDishById(currentFavoriteDishId);
        if (dishInDB == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dish with ID " + currentFriendId + " does not exist", null));
        } else {
            if (currentUser.getFavoriteDishes().contains(dishInDB)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dish with ID " + currentFriendId + " is already in favorite dish list for user with ID " + currentId, null));
            } else {
                em.getTransaction().begin();
                currentUser.getFavoriteDishes().add(dishInDB);
                em.persist(currentUser);
                em.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dish with ID " + currentFriendId + " added to favorite dish list for user with ID " + currentId, null));
            }
        }
    }
}

