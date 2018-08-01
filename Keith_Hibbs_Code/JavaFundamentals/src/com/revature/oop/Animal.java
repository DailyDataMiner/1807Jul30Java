package com.revature.oop;

public abstract class Animal implements Livable{

	public void consume() {System.out.println("Animals consume things to live" + helperMethod() );
		
	}
	private static int helperMethod() {
		return 0;
	}
}
