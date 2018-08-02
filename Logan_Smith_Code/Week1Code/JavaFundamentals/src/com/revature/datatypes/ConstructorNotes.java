package com.revature.datatypes;

public class ConstructorNotes {

	
	/*
	 * 
	 * Constructor always calls another constructor in the first line. This, Super, or default (object class constructor)
	 * Unless this() is declared, it basically just calls super
	 * Every concrete class has a constructor, but it disappears as soon as a constructor is created
	 * Looks like no args constructor, but not one
	 * 
	 */
	
	String name;
	int age;
	String email;
	String hairColor;
	
	static Integer integer;
	static double d;
	static byte b;
	static int i;
	static float f;
	static boolean bool;
	static short s;
	static char c;
	static long l;
	
	public ConstructorNotes() {
		
	}
	
	public ConstructorNotes(String name) {
		this(name, 20, "nuwmancer", "blond");
	}
	
	public ConstructorNotes(String name, int age, String email, String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.hairColor = hairColor;
	}
	
	
	
	
	
}
