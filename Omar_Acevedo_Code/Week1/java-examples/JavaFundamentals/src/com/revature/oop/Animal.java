package com.revature.oop;
import com.revature.helpers.HelperFunctions;

public abstract class Animal extends HelperFunctions implements Livable {
	/**
	 * Abstract classes have the ability to have 
	 * 	abstract methods (unimplemented methods)
	 * 	They do NOT need to have an abstract method
	 * 	to be abstract. they just have the ability to
	 */
	
	String className = "Animal";
	public void consume() {
		System.out.println("Animal eat things to consume, ... " + helperMethod());
	}

//	public void consume(String p_animal) {
//		System.out.println(p_animal + " animal eat things to consume, ... " + helperMethod());
//	}
	
	private static int helperMethod() {
		return 28;
	}
	
}
