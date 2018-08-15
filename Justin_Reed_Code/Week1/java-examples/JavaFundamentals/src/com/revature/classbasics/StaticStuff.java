package com.revature.classbasics;

public class StaticStuff {
	
	static {
		System.out.println("In Block Before Main Method");
	}
	
	public static void main(String[] args) {
		
		System.out.println("In Main Method");
		
	}

	static {
		System.out.println("In After Before Main Method");
	}
	
}
