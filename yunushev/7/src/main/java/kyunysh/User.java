package kyunysh;

import java.net.URL;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer userId;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private String password;
	@Column
	private URL photoUrl;
	@ManyToMany
	private List<User> friends;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return userId;
	}

	public void setId(final Integer id) {
		userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(final String secondName) {
		this.secondName = secondName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public URL getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(final URL PhotoUrl) {
		photoUrl = PhotoUrl;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(final List<User> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, userId, password, photoUrl, secondName);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		final User user = (User) obj;
		return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName)
				&& Objects.equals(secondName, user.secondName) && Objects.equals(password, user.password)
				&& Objects.equals(photoUrl, user.photoUrl);
	}

}
