package com.seprokof.usercard.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "keys", initialValue = 4, allocationSize = 1)
@NamedQueries({ @NamedQuery(name = UserCard.GET_ALL, query = "SELECT u FROM UserCard u") })
@NamedNativeQueries({
		@NamedNativeQuery(name = UserCard.GET_AVAILABLE_FRIENDS_FOR_ID, query = "select * from users where id <> ?1 and id not in (select follower_id from users_friends where user_id = ?1)", resultClass = UserCard.class) })
public class UserCard implements Serializable {
	private static final long serialVersionUID = -7283883422942242603L;
	public static final String GET_ALL = "getAllUsers";
	public static final String GET_AVAILABLE_FRIENDS_FOR_ID = "getAvailableFriendsForId";

	private Long id;
	private String firstName;
	private String lastName;
	private String password;
	private String pictureLink;
	private Set<String> dishes = new HashSet<>();
	private List<UserCard> friends = new ArrayList<>();
	private List<UserCard> friendOf = new ArrayList<>();

	public UserCard() {
		super();
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "keys")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = true)
	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@CollectionTable(name = "User_dishes")
	@Column(name = "Title")
	@ElementCollection(fetch = FetchType.EAGER)
	public Set<String> getDishes() {
		return dishes;
	}

	public void setDishes(Set<String> dishes) {
		this.dishes = dishes;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "users_friends", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "follower_id", nullable = false) })
	public List<UserCard> getFriends() {
		return friends;
	}

	public void setFriends(List<UserCard> friends) {
		this.friends = friends;
	}

	@ManyToMany(mappedBy = "friends")
	public List<UserCard> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<UserCard> friendOf) {
		this.friendOf = friendOf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pictureLink == null) ? 0 : pictureLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCard other = (UserCard) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pictureLink == null) {
			if (other.pictureLink != null)
				return false;
		} else if (!pictureLink.equals(other.pictureLink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCard [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", pictureLink=" + pictureLink + ", dishes=" + dishes + "]";
	}

}
