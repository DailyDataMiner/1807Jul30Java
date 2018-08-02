package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	public static void main (String args[]) {
		
		try {
		throwingCustom("Well, hello there!");
		exploreStack(args); // Any time an exception is thrown, it must be handled
		}
		catch(MyException me) {
			me.printStackTrace();
			System.out.println("My exception! Nooo!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("THROWING");
		}
		System.out.println("Reached the end");
	}
	static void doThings(String[] args) {
		try {
		System.out.println(args[0].toLowerCase());
		throw new IOException();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Caught array index oob");
		}
		catch (IOException e) {
			
		}
	}
	
	static void exploreStack(String[] args) throws IOException { // indicates that this method will throw an exception (handle it!)
		doThings(args);
		
		String file = "test.txt";
		FileWriter fw = new FileWriter(file);
		
		//throw new Exception();
	}
	
	static void throwingCustom(String issue) throws MyException {
		String message = "This is our problem: " + issue;
		throw new MyException(message);
	}
}
