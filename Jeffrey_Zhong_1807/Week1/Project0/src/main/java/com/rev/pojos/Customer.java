package com.rev.pojos;

public class Customer {

	private int CustomerID;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;

	public Customer() {
	}

	public Customer(int id, String fn, String ln, String un, String pw) {
		super();
		this.CustomerID = id;
		this.FirstName = fn;
		this.LastName = ln;
		this.UserName = un;
		this.Password = pw;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return " Customer [CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", UserName=" + UserName + ", Password=" + Password + "]";
	}

}
