package com.seprokof.usercard.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.seprokof.usercard.dao.UserCard;
import com.seprokof.usercard.service.UserService;

/**
 * Handles users management view.
 * 
 * @author seprokof
 *
 */
@ManagedBean(name = "userCardViewBean")
@ViewScoped
public class UserCardViewBean implements Serializable {
	private static final long serialVersionUID = 6395273106537647094L;
	private UserCard selectedUser;
	private UserCard freshUser = new UserCard();
	private String newDish;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Populate table
	 * 
	 * @return
	 */
	public List<UserCard> getUsers() {
		return userService.getAllUsers();
	}

	public UserCard getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserCard selectedUser) {
		this.selectedUser = selectedUser;
	}

	public UserCard getFreshUser() {
		return freshUser;
	}

	public void setFreshUser(UserCard freshUser) {
		this.freshUser = freshUser;
	}

	public String getNewDish() {
		return newDish;
	}

	public void setNewDish(String newDish) {
		this.newDish = newDish;
	}

	public void addFood() {
		freshUser.getDishes().add(newDish);
		newDish = null;
	}

	/**
	 * Double click handler.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void onRowDblClckSelect(SelectEvent event) throws IOException {
		UserCard obj = (UserCard) event.getObject();
		FacesContext.getCurrentInstance().getExternalContext().redirect("user.xhtml?id=" + obj.getId());
	}

	/**
	 * User add handler
	 * 
	 */
	public void addUser() {
		try {
			userService.addUser(freshUser);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User has been added", null));

			freshUser = new UserCard();
			newDish = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to add User: " + e.getMessage(), null));
		}
	}

}
