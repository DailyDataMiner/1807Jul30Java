package com.revature.pojos;


public class Users {
	private int id;
	private String fName;
	private String lName;
	private String username;
	private String password;
public Users() {}

public Users(int id, String name) {
	super();
	this.id = id;
	this.fName = fName;
}


@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}

public String getLname() {
	return lName;
}

public void setLname(String lname) {
	this.lName = lname;
}

public String getUsername() {
	return username;
}

public void setUsername(String uname) {
	this.username = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String pword) {
	this.password = pword;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}
}