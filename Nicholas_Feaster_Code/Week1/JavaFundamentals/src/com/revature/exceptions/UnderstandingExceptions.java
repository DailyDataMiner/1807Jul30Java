package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	
	public static void main(String[] args) {
		
		
		try {
		doThings(args);		
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Catching exception e in main method");
		}
		System.out.println("Reached the end of first risky code block");
		
		try {
			propagate();
		} catch (MyException e) {
			System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
			//e.getMessage();
			//e.printStackTrace();
		}
		}
	
	
	static void doThings(String[] args) {
		try { //MUST use either catch,finally, or finally
		System.out.println(args[5].toLowerCase());
			throw new IOException();//allow you to throw an exception
		}
		catch(IOException e){
			System.out.println("Caught IOE");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Caught AIOOBE");
		}
		
		}
	
	static void exploreStack(String[] args) throws IOException {//goes after is method will throw and exception
		doThings(args);
		System.out.println("About to throw a new exception from explore stack");
		//throw new Exception();
		String file = "test.txt";
		FileWriter write = new FileWriter(file);
	}
	static void throwingCustom(String issue) throws MyException {
		String arg0 = "This is our problem; " + issue;
		throw new MyException(arg0);
	}
	static void propagate() throws MyException {
		throwingCustom("In propagate method, calling method that throws an exception.");
	}
}