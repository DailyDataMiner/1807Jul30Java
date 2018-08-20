package com.rev.pojos;

public class UserClient { //Genre
	
	private int customerId;
	private String username;
	private String password;
	private int doesExist;
	
	public UserClient(int customerId, String username, String password) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
	}
	
	
	public UserClient() {}
	
	
	public UserClient(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}

	public int isDoesExist() {
		return doesExist;
	}


	public void setDoesExist(int doesExist) {
		this.doesExist = doesExist;
	}
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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


	@Override
	public String toString() {
		return "UserClient [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", getCustomerId()=" + getCustomerId() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}