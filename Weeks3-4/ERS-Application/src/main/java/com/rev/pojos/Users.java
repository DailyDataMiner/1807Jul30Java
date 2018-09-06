package com.rev.pojos;

public class Users {
	
	private int usersID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleID;
	
	
	public Users() {
		super();
	}
	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	public Users(int usersID, String username, String password, String firstName, String lastName, String email,
			int roleID) {
		super();
		this.usersID = usersID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleID = roleID;
	}
	
	public Users( String username, String password, String firstName, String lastName, String email, int roleID) {
		super();
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleID = roleID;
		
	}

	public int getUsersID() {
		return usersID;
	}

	public void setUsersID(int usersID) {
		this.usersID = usersID;
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

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Override
	public String toString() {
		return "Users [usersID=" + usersID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleID=" + roleID + "]";
	}
	
	
	

}
