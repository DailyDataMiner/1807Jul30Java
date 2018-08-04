package com.revature.designpatterns;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	public String name;
	/*
	 * singleton design pattern
	 * 		used in scenarios which require only one instance of an object to be created
	 * 
	 * private constructor prevents any other class from instantiating this object
	 */
	
	private Singleton() {
		
	}

	public static Singleton getInstance() {
		return singleton;
	}

}
