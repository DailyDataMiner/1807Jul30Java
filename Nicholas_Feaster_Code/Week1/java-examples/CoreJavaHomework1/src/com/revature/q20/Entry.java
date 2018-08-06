package com.revature.q20;

public class Entry {
	public String firstname;
	public String lastname;
	public int age;
	public String state;
	
	public Entry() {
		
	}
	
	public Entry(String firstname, String lastname, int age, String state) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.state = state;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return firstname + ";" +lastname + ";" +  age + ";" + state+ ";" + "\n";
	}
	 

}
