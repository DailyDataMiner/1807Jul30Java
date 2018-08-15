package com.rev.pojos;

public class BankUser {
	
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	
	public BankUser() {};
	
	public BankUser(String firstName, String lastName, String email, String userName, String password) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	

	public BankUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public BankUser(int userID, String firstName2, String lastName2, String email2, String userName2,
			String password2) {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BankUsers [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	

}
