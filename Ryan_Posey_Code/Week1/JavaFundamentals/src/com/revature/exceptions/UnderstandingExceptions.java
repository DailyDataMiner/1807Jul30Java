package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args){
		try {
			exploreStack(args);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Catching exception e in main method");
		}
		System.out.println("Reached the end of first risky code block");
		
		try {
		propagate();
		}
		catch(MyException e) {
			System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
		}
	}

	static void doThings(String[] args) {
		try { // must use either a catch, finally, or both
			System.out.println(args[5].toLowerCase());
			throw new IOException();
		}
		catch(IOException e) {
			System.out.println("Caught IOE");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Caught AIOOBE");
		}
	}
	
	static void exploreStack(String[] args) throws Exception{
		doThings(args);
		System.out.println("About to throw new exception from explore stack");
		String file = "test.txt";
		FileWriter write = new FileWriter(file);
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
	
	static void propagate() throws MyException {
		throwingCustom("In propagate method, calling method that throws an exception");
	}
}