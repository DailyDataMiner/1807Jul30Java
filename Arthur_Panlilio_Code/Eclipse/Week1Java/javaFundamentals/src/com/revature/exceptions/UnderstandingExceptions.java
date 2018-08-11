package com.revature.exceptions;

import java.io.*;

public class UnderstandingExceptions {
	
		public static void main(String [] args) {
			
			
			try {
				exploreStack(args);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Catching exception e in main method");
			}
			
			System.out.println("Reached the end of first risky code block!");
			
			try {
				propagate();
			} catch (MyException e){
				System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
			}
		}
		
		static void doThings(String[] args) {
			try { //Must use either a catch, finally, or both
				System.out.println(args[5].toLowerCase());
				throw new IOException(); //Allow you to throw an exception at this line of code
			}			
			catch(IOException e) {
				System.out.println("Caught IO Exception");
			}
			catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("Caught index out of bounds exception");
			}
			catch(Exception e){
				System.out.println("general backup behaviour");
				if(e instanceof IOException) {
					System.out.println("Caught IO Exception");
				} else if(e instanceof ArrayIndexOutOfBoundsException) {
					System.out.println("caught index out exception");
				}
			}
		}
		
		static void exploreStack(String[] args) throws Exception { //Goes after method signature; indicates that this method will throw its exception and calling method must "handle" it
			doThings(args);
			System.out.println("About to throw new exception from explore stack!");
			String file = "/test.txt";
			FileWriter write = new FileWriter(file);
		}
		
		static void throwingCustom(String issue) throws MyException {
			String message = "This is our problem: " + issue;
			throw new MyException(message);
		}
		
		static void propagate() throws MyException{
			throwingCustom("In propagate method calling method that throws an exception");
		}
		
		
		
		

}
