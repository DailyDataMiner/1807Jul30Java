package com.revature.designpatterns;
import com.revature.helpers.HelperFunctions;

public class Singleton extends HelperFunctions {
	
	// Eager
	
	public String name;	// to demonstrate the single instance
	private static Singleton singleton = new Singleton();
	
	/**
	 * Singleton design pattern - used in scenarios
	 * 	which require only one instance of an object to be created
	 * 
	 * The private constructor prevents any other class 
	 * from instiantiating this object
	 * 
	 */
	
	private Singleton() {
		print("... eager");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
}
