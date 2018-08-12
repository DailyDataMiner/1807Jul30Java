package com.revature.intro;

public class Constructors {
	/*
	 * A constructor is a special method in java
	 *  used to CONSTRUCT or create a new instance 
	 *  of the class it is found in
	 *  it must have the same name as the calss
	 *  it does not have a terurn type
	 *  it can be overloaded
	 *  the first line, whetehr implicitly or explicitily
	 *  is ALWAYS a call to another constructor -- either 
	 *  this() (calling another constructor of the same class) 
	 *  or super() (calls it superclass's constructor
	 *  
	 */

	String name;
	int age;
	String email;
	String hairColor;
	
	//Constructors c = new Constructors();
	public Constructors() {
		
	}
	
	public Constructors(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructors(int age) {
		this.age = age;
	}
	
	public Constructors(String name, int age, String email, String hairColor) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}
	
	
}