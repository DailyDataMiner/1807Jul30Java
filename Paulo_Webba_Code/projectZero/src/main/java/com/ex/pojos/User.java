package com.ex.pojos;

public class User {
	
	private int id;
	private String firstname; 
	private String lastname;
	private String username; 
	private String email;
	private String pwd;
	//private int personID;
	
	public User() {}
	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
		
	}
	
	public User(int id, String firstname, String lastname, String email, String username, String pwd) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.pwd = pwd;
	}
     
    
	public User(String firstname, String lastname,  String email, String username, String pwd) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.pwd = pwd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	
     
}
