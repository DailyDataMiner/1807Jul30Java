package com.revature.week1.Q20;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	
	public Person(String str) {
		String[] split = str.split(":");
		this.firstName = split[0];
		this.lastName = split[1];
		this.age = Integer.parseInt(split[2]);
		this.state = split[3].replaceAll("\n", "");
	}
	
	public void display() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Age: " + age + " years");
		System.out.println("State: " + state + " State");
		System.out.println();
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
	
	
}
