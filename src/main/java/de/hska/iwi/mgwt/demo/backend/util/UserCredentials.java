package de.hska.iwi.mgwt.demo.backend.util;

public class UserCredentials {
	
	private final String username;
	
	private final String password;
	
	public UserCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
