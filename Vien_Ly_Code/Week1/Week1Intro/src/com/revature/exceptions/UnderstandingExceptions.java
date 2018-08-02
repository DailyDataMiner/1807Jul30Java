package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {

		
		try {
			exploreStack(args);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catching e in main");
		}
		
		System.out.println("reached end of main");
		
		try {
			propagate();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("propagated to main");
			e.printStackTrace();
		}
	}
	
	static void doThings(String[] args) {
		// MUST PUT THE MOST SPECIFIC EXCEPTION FIRST
		try { // must use catch, finally, or both
			System.out.println(args[5].toLowerCase());
			throw new IOException(); // allow you to throw exception at this line of code
		} catch (IOException e) { // if you never threw IO you wouldn't catch it, not runtime exception
			System.out.println("caught IO");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("caught AIOB");
		} catch (Exception e) { // least specific exception last
			
		}
		
	}

	static void exploreStack(String[] args) throws Exception {
		doThings(args);
		System.out.println("about to throw new Exception from explore stack");
		String file = "test.txt";
		FileWriter write = new FileWriter(file);
	}
	
	static void throwingCustom(String issue) throws MyException{
		String message = "this is our problem: " + issue;
		throw new MyException(message);
	}
	
	static void propagate() throws MyException {
		throwingCustom("IN propagate method calling throwingCustom");
	}
}
