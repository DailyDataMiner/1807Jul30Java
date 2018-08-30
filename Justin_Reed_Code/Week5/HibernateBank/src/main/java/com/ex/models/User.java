package com.ex.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity @Table(name="Ex_Users")
public class User {
	
	@Id @SequenceGenerator(name="EXU_ID", sequenceName="EXU_ID")
	@GeneratedValue(generator="BU_ID", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	public User() {
		super();
	}
	public User(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int u) {
		this.id = u;
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	

}
