package com.revature.exceptions;

public class UnderstandingExceptions {
	
	public static void main(String[] args) {
		
		exploreStack(args);
		
	}
	
	static void doThings(String[] args) {
		System.out.println(args[5].toLowerCase());
	}
	
	static void exploreStack(String[] args) {
		
		
		doThings(args);
	}

}
