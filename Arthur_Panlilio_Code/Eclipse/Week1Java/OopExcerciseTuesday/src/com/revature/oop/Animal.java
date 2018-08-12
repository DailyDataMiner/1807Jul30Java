package com.revature.oop;

public class Animal implements Feed {
	
	private String name;
	private int age;
	
	public Animal(String theName) {
		this(theName, 1);
	}
	
	public Animal(int theAge) {
		this("The Beast with no Name", theAge);
	}
	
	public Animal(String theName, int theAge) {
		name = theName;
		age = theAge;
	}
	
	

	@Override
	public void eat() {
		System.out.println("My name is " + name + " and I eat stuff!");
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}