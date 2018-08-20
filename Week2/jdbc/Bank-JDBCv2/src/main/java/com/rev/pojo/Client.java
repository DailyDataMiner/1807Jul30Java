package com.rev.pojo;

public class Client {

	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	
	public Client() {};
	
	public Client(String username) {
		super();
		this.username = username;
	}
	
	public Client(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	
	public Client(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}


	public Client(int userid, String firstname, String lastname, String username, String password) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		return "Client [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}

	

}
