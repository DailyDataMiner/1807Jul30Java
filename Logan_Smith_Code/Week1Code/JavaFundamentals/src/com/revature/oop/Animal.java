package com.revature.oop;

public abstract class Animal implements Livable {
	/*
	 * Abstract classes have the ability to have
	 * abstract methods (unimplemented methdods)
	 * they do not need to have an abstract method
	 * to be abstract, they just have the ability
	 */
	
	String className = "Animal";
	
	public void consume() {
		System.out.println("Animals need to consume things I guess. " + helperMethod());
	}
	
	private static int helperMethod() {
		
		return 0;
	}
	
}
