package com.bank.pojos;

public class Person {
	
	private int personid;	
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalcode;
	private String phone;
	private int userid;
	
	public Person() {
		super();
	}
	
	// Id (personid) gets generated from db.
	public Person(String firstname, String lastname, String address, String city, String state, String country,
			String postalcode, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.phone = phone;
	}

	public Person(int personid, String firstname, String lastname, String address, String city, String state,
			String country, String postalcode, String phone, int userid) {
		super();
		this.personid = personid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.phone = phone;
		this.userid = userid;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Person [personid=" + personid + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", city=" + city + ", state=" + state + ", country=" + country + ", postalcode="
				+ postalcode + ", phone=" + phone + ", userid=" + userid + "]";
	}
	
}
