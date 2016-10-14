package kyunysh;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kyunysh.dao.UserDao;

@Named
@RequestScoped
public class UserPageController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao users;
	private User currentUser = new User();

	public UserPageController() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return currentUser.getId();
	}

	public void setId(final Integer id) {
		currentUser = users.getUser(id);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public String getFavouriteDish() {
		System.out.println("getFavouriteDish: ");
		return null;
	}

	public Set<String> getFavouriteDishes() {
		return currentUser.getFavouriteDishes();
	}

	public String saveUser() {
		users.saveUser(currentUser);
		return "management";
	}

	public void setFavouriteDish(final String favouriteDish) {
		currentUser.addfavouriteDish(favouriteDish);
		users.saveUser(currentUser);
	}

	public String getDishToRemove() {
		System.out.println("getDishToRemove: ");
		return null;
	}

	public void setDishToRemove(final String dishToRemove) {
		System.out.println("setDishToRemove: " + dishToRemove);
		currentUser.removeFavouriteDish(dishToRemove);
		users.saveUser(currentUser);
	}

	public Collection<User> getPossibleFriends() {
		final Set<User> possibleFriends = new HashSet<User>();
		if(users.getUsers() != null) {
			possibleFriends.addAll(users.getUsers());
		}
		if(currentUser.getFriends() != null) {
			possibleFriends.removeAll(currentUser.getFriends());
		}
		return possibleFriends;
	}

	public User getFriendCandidate() {
		System.out.println("getFriendCandidate: ");
		return null;
	}

	public void setFriendCandidate(final User friendCandidate) {
		System.out.println("setFriendCandidate: " + friendCandidate);
		currentUser.addFriend(friendCandidate);
		users.saveUser(currentUser);
	}

	public User getFriendToRemove() {
		System.out.println("getFriendToRemove: ");
		return null;
	}

	public void setFriendToRemove(final User friendToRemove) {
		System.out.println("setFriendToRemove: " + friendToRemove);
		currentUser.removeFriend(friendToRemove);
		users.saveUser(currentUser);
	}
}
