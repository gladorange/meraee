package kyunysh;

import java.io.Serializable;

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

	public void saveUser() {
		users.saveUser(currentUser);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public Integer getId() {
		return currentUser.getId();
	}

	public void setId(final Integer id) {
		currentUser = users.getUser(id);
	}
}
