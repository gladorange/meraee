package kyunysh;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kyunysh.dao.UsersDao;

@Named
@RequestScoped
public class UserPageController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsersDao users;
	private User currentUser = new User();
	private boolean isNewUser = true;

	public UserPageController() {
		// TODO Auto-generated constructor stub
	}

	public void saveUser() {
		if (isNewUser) {
			users.addUser(currentUser);
		}
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public Integer getId() {
		return currentUser.getId();
	}

	public void setId(final Integer id) {
		isNewUser = false;
		currentUser = users.getUser(id);
	}
}
