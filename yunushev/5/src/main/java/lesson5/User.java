package lesson5;

import java.net.URL;

public class User {

	private int id;
	private String firstName;
	private String secondName;
	private String password;
	private URL fotoUrl;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
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

	public URL getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(final URL fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

}
