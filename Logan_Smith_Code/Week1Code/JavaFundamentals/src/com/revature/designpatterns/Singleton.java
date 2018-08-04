package com.revature.designpatterns;

//Eager
public class Singleton {

	public String name;
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
}
