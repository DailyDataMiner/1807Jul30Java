package servlets.models;

import beans.UserRole;

public class UserData {
	// username, password, firstname, lastname, email

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;

	public UserData() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserData [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + "]";
	}

}
