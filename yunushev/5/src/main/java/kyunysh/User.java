package kyunysh;

import java.net.URL;

public class User {

	private String itsId;
	private String itsFirstName;
	private String itsSecondName;
	private String itsPassword;
	private URL itsPhotoUrl;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return itsId;
	}

	public void setId(final String id) {
		this.itsId = id;
	}

	public String getFirstName() {
		return itsFirstName;
	}

	public void setFirstName(final String firstName) {
		this.itsFirstName = firstName;
	}

	public String getSecondName() {
		return itsSecondName;
	}

	public void setSecondName(final String secondName) {
		this.itsSecondName = secondName;
	}

	public String getPassword() {
		return itsPassword;
	}

	public void setPassword(final String password) {
		this.itsPassword = password;
	}

	public URL getPhotoUrl() {
		return itsPhotoUrl;
	}

	public void setPhotoUrl(final URL PhotoUrl) {
		this.itsPhotoUrl = PhotoUrl;
	}

}
