package com.revature.classbasics;

public class Constructors {
	
	/*
	 * A constructor is a special method in java 
	 * used to CONSTRuCT or create a new instance 
	 * of the class it is found in 
	 * it must have the same name as the class
	 * it does not have a return type 
	 * it can be overloaded 
	 * the first line, whether implicit or explicit,
	 * is ALWAYS a call to another constructor -- either
	 * this() (calling to another constructor of the same 
	 * class) or super() (calls its superclass's constructor. 
	 * if there is no class 
	 * 
	 * 
	 * 
	 */

	
	//dummy instance vars:
	String name;
	int age;
	String email;
	String hairColor;
	
	//no args cnstrcutor
	public Constructors() {}
	
	public Constructors(String name) {
		this(name, 20, "test@gmail.com", "brown");
	}
	
	public Constructors(String name, int age, String email, String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}
	
	//Constructors c = new constructor 
}
