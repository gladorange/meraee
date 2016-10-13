package kyunysh;

import java.net.URL;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private String password;
	@Column
	private URL photoUrl;
	@ElementCollection(targetClass = String.class)
	@Column
	private Set<String> favouriteDishes;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<User> friends;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
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

	public Set<User> getFriends() {
		return friends;
	}

	public void addFriend(final User friend) {
		friends.add(friend);
	}

	public void setFriends(final Set<User> friends) {
		this.friends = friends;
	}

	public Set<String> getFavouriteDishes() {
		return favouriteDishes;
	}

	public void setFavouriteDishes(final Set<String> favouriteDishes) {
		this.favouriteDishes = favouriteDishes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, password, secondName);
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
		return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName)
				&& Objects.equals(secondName, user.secondName) && Objects.equals(password, user.password);
	}

}
