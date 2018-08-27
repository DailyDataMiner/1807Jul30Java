package com.ex.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private int empID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int roleID;

	public Employee() {

	}

	public Employee(int empID, String username, String password, String firstname, String lastname, String email,
			int roleID) {
		super();
		this.empID = empID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleID = roleID;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", roleID=" + roleID + "]";
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

}
