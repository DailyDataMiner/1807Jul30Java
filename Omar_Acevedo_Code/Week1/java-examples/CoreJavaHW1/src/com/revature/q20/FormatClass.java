package com.revature.q20;

public class FormatClass {
	
	private String name;
	private int age;
	private String state;
	
	public FormatClass(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
	}
	
	@Override
	public String toString() {
		
		return "Name: " + name + "\nAge: " + age + " years\nState: " + state + " State\n";
	}
}
