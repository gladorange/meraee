package com.seprokof.usercard.ui;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import com.seprokof.usercard.dao.UserCard;
import com.seprokof.usercard.service.UserService;

/**
 * Handles user card view.
 * 
 * @author seprokof
 *
 */
@ManagedBean(name = "userEditorViewBean")
@ViewScoped
public class UserEditorViewBean implements Serializable {
	private static final long serialVersionUID = 3735544668623582235L;

	private UserCard original;
	private UserCard current;
	private Long id;
	private DualListModel<UserCard> available;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserCard getOriginal() {
		return original;
	}

	public void setOriginal(UserCard original) {
		this.original = original;
	}

	public UserCard getCurrent() {
		return current;
	}

	public void setCurrent(UserCard current) {
		this.current = current;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DualListModel<UserCard> getAvailable() {
		return available;
	}

	public void setAvailable(DualListModel<UserCard> available) {
		this.available = available;
	}

	public void init() {
		if (current == null) {
			current = userService.getUserById(id);
		}
		if (available == null) {
			available = new DualListModel<>();
		}
	}

	/**
	 * User update handler
	 * 
	 */
	public void updateUser() {
		try {
			// find users which were friends with the current
			available.getSource().retainAll(current.getFriends());
			// refresh active friends
			current.getFriends().clear();
			current.getFriends().addAll(available.getTarget());
			current = userService.updateUser(current, available.getSource());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User has been updated", null));

			// prepare for the new update
			original = null;
			available.getSource().clear();
			available.getTarget().clear();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to update User: " + e.getMessage(), null));
		}
	}

	/**
	 * User delete handler
	 * 
	 */
	public void deleteUser() {
		try {
			userService.deleteUser(current);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User has been deleted", null));

			// redirect to list page
			FacesContext.getCurrentInstance().getExternalContext().redirect("listView.xhtml");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to delete User: " + e.getMessage(), null));
		}
	}

	/**
	 * Backup previous value
	 * 
	 */
	public void makeEditable() {
		original = new UserCard();
		original.setId(current.getId());
		original.setFirstName(current.getFirstName());
		original.setLastName(current.getLastName());
		original.setPassword(current.getPassword());
		original.setPictureLink(current.getPictureLink());
		original.setFriends(current.getFriends());
		original.setDishes(current.getDishes());

		// populate available and current friends sources
		available.getSource().clear();
		available.getSource().addAll(userService.getPossibleFriends(id));
		available.getTarget().clear();
		available.getTarget().addAll(current.getFriends());
	}

	/**
	 * Revert to original
	 * 
	 */
	public void cancelUpdate() {
		current.setId(original.getId());
		current.setFirstName(original.getFirstName());
		current.setLastName(original.getLastName());
		current.setPassword(original.getPassword());
		current.setPictureLink(original.getPictureLink());
		current.setFriends(original.getFriends());
		current.setDishes(original.getDishes());
		original = null;
	}

}
