package com.revature.oop;

// access mod / non-access mods / class / className
public  abstract class Animal implements Livable{
	/*
	 * Abstract classes have the ability to be have abstract methods(unimplemented methods)
	 * They don't need to have an abstract method to be abstract. They just have the ability to.
	 */
	String className = "Animal";
	public void consume() {
		System.out.println("Animal eat things to consume: " + helperMethod());
	}
	private static int helperMethod(){
		return 0;
	};
}
