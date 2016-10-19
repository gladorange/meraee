package kyunysh;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private String password;
	@Column
	private URL photoUrl;
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	private Set<String> favouriteDishes = new HashSet<String>();
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
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

	public void removeFriend(final User friend) {
		friends.remove(friend);
	}

	public Set<String> getFavouriteDishes() {
		return favouriteDishes;
	}

	public void addfavouriteDish(final String favouriteDish) {
		favouriteDishes.add(favouriteDish);
	}

	public void removeFavouriteDish(final String favouriteDish) {
		favouriteDishes.remove(favouriteDish);
	}

	public void setFavouriteDishes(final Set<String> favouriteDishes) {
		this.favouriteDishes = favouriteDishes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, password, secondName, photoUrl);
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
				&& Objects.equals(secondName, user.secondName) && Objects.equals(password, user.password)
				&& Objects.equals(photoUrl, user.photoUrl);
	}

}
