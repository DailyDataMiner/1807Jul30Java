package com.Rev.assoc.Proj0.ZeroNationalBank;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
		static Scanner ZNBScanner = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( "Hello! Welcome to ZNB!" );
        menu();
    }
    
    static void menu() {
    	System.out.println("Please select a option:\n"
    			+ "1. Create a new account.\n"
    			+ "2. Login to an existing account. ");
    	int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(ZNBScanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 2 :)");
			menu();
		}
		switch(option) {
		case 1:
			()
		case 2:
			
		}
		
		
		
    }
    
}
