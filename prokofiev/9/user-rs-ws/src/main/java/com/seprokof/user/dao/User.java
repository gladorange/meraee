package com.seprokof.user.dao;

/**
 * This class represent full information about user.
 * 
 * @author seprokof
 *
 */
public class User extends SecuredUser {
	private static final long serialVersionUID = -8466248254599114615L;

	private String password;

	public User() {
		super();
	}

	public User(Long id, String firstName, String lastName, String password, String pictureLink) {
		super(id, firstName, lastName, pictureLink);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", pictureLink=" + getPictureLink() + ", password=" + password + "]";
	}

}
