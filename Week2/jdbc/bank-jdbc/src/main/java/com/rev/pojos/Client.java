package com.rev.pojos;

import java.math.BigInteger;

public class Client {

	private int customerId;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String country;

	private String email;

	public Client() {
	};

	public Client(String firstName, String lastName, String streetAddress, String city, String state, String country,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
	}

	public Client(int customerId, String firstName, String lastName, String streetAddress, String city, String state,
			String country, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", email=" + email + ", getCustomerId()=" + getCustomerId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getStreetAddress()=" + getStreetAddress() + ", getCity()="
				+ getCity() + ", getState()=" + getState() + ", getCountry()=" + getCountry() + ", getEmail()="
				+ getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
