package com.revature.classbasics;

public class Scopes {
	/*Scopes 
	 * The lifetime of a variable 
	 * There are four different scopes in Java 
	 * Class/Static = This is what we mean by global
	 * static entities =(vars, methods, nested classes) are
	 * accessible from outside of the class WITHOUT an instance 
	 * 
	 * 
	 * 
	 * 
	 * Object/Instance = the object's fields/state
	 * 	Entities in this scope can only be accessed by an instance 
	 * 	of the object they belong to 
	 * 
	 */
	
	int age;
	String name;
	static int count;
	
	public Scopes() {
		// constructors. will
		count++;
	}
	
	public static void main(String[] args) {
		Integer num = new Integer(5);
		Integer x = new Integer(151526);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		Scopes s = new Scopes ();
		s.age = 16;
		doThings();
		
		
	}
	
	static void doThings() {
		//test();
	}
	
	void test() {
		
	}

}
