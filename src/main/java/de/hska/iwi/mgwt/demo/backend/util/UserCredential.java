package de.hska.iwi.mgwt.demo.backend.util;

/**
 * Holds credentials for a user, for authentication purposes.
 * @author Nico
 *
 */
public class UserCredential {
	
	private final String username;
	
	private final String password;
	
	/**
	 * C'tor which sets the username as well as the password for a user.
	 * @param username username for authentication
	 * @param password corresponding password for the authentication
	 */
	public UserCredential(String username, String password) {
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
