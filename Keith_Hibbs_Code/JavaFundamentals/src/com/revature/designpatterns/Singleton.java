package com.revature.designpatterns;

public class Singleton {
public String name;
	
	private static Singleton singleton = new Singleton();
	
	/*
	 * Singleton design pattern - used in scenarios which require only one instance of an object to be created
	 * 
	 * the private constuctor prevents any other class from instantiating this object
	 */
	private Singleton() {}
System.output.println("")
	public static Signleton getInstance() {
		return singleton;
		
	}
}
