package com.revature.oop;

public abstract class Animal implements Livable{
	
	/*
	 * Abstract class have the ability to have abstract methods
	 * (unimplemented method)
	 * they do not need to have an abstract method to be abstract.
	 * They just have the ability to. 
	 */
	
	String className = "Animal";
	
	public void consume() {
		System.out.println("Animals eat things to consume " + helperMethod());
	}
	
	private static int helperMethod() {
		return 0;
	}
	
	public void haha() {
		System.out.println(className + "haha");
	}

}
