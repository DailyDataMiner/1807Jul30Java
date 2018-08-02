package com.revature.exceptions;
import com.revature.helpers.HelperFunctions;

public class UnderstandingExceptions extends HelperFunctions {
	
	public static void main(String[] args) {
	
//		doThings(args);
		
//		throwingCustom(" Oh No!");
		try {
			propagate();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print(e.getMessage());
		}
		
	}
	
	public static void doThings(String[] args) {
		
		print(args[3].toLowerCase());
		
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
	
	static void propagate() throws MyException {
		throwingCustom("Uh Oh");
	}
	
}
