package com.rev.pojos;

public class Client {

	private int customerId;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private int zip;
	private int phone;
	private String email;
	
	
	
	public Client() {}



	public Client(int customerId, String firstName, String lastName, String streetAddress, String city, String state,
			String country, int zip, int phone, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
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



	public int getZip() {
		return zip;
	}



	public void setZip(int zip) {
		this.zip = zip;
	}



	public int getPhone() {
		return phone;
	}



	public void setPhone(int phone) {
		this.phone = phone;
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
				+ ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", getCustomerId()=" + getCustomerId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getStreetAddress()="
				+ getStreetAddress() + ", getCity()=" + getCity() + ", getState()=" + getState() + ", getCountry()="
				+ getCountry() + ", getZip()=" + getZip() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
	
	
}
