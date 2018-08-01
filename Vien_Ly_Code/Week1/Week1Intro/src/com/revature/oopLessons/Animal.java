package com.revature.oopLessons;

public abstract class Animal implements Livable {
	public void consume() {
		System.out.println("animals eat things to consume " + helperMethod());
	}
	
	private int helperMethod() {
		return 0;
	}
}
