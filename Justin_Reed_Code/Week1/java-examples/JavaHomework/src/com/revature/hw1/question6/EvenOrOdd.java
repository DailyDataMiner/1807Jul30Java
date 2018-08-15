package com.revature.hw1.question6;

import java.util.Scanner;

public class EvenOrOdd {
	
	    // This program uses a boolean value to check if a number is even.
		// Using a loop to switch the boolean to false when odd and true
	    // when even.
	    static boolean Even(int n)
	    {
	        boolean Even = true;
	         
	        for (int i = 1; i <= n; i++) 
	            Even = !Even;
	             
	        return Even;
	    }
	     
	     
	    
	    public static void main(String args[])
	    {
	    	
			//Initialized as 1, but allows user to input a number 
	        int n = 1;
	        Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			scan.close();
	        if(Even(n))
	            System.out.println("Even");
	        else
	            System.out.println("Odd");
	         
	    }
	}
	


