package com.revature.projectZero.POJO;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private List<Account> accounts;
	
	public User(String firstName, String lastName, String userName, String password) {
		this.userId = -1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accounts = new ArrayList<Account>();
	}

	public User(int userId, String firstName, String lastName, String userName, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accounts = new ArrayList<Account>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", Name=" + firstName + " " + lastName + ", userName=" + userName
				+ ", numAccounts=" + accounts.size() + "]";
	}

}
