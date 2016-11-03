package com.seprokof.user.dao;

import java.io.Serializable;

/**
 * This class represents safe-to-display user record.
 * 
 * @author seprokof
 *
 */
public class SecuredUser implements Serializable {
	private static final long serialVersionUID = 4672853057109548233L;

	private Long id;
	private String firstName;
	private String lastName;
	private String pictureLink;

	public SecuredUser() {
		super();
	}

	public SecuredUser(Long id, String firstName, String lastName, String pictureLink) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pictureLink = pictureLink;
	}
	
	public SecuredUser(SecuredUser user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.pictureLink = user.pictureLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pictureLink == null) ? 0 : pictureLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SecuredUser)) {
			return false;
		}
		SecuredUser other = (SecuredUser) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (pictureLink == null) {
			if (other.pictureLink != null) {
				return false;
			}
		} else if (!pictureLink.equals(other.pictureLink)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SecuredUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pictureLink="
				+ pictureLink + "]";
	}

}
