package com.revature.hw1.question2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {
	
	//Fibonacci sequences are a sequence for numbers where the next 
	//number is the combination of the previous 2. So n = (n-1) + (n-2)
	static int fib(int n)
    {
		//for cases where the sequence starts at 0 or 1.
    if (n <= 1)
       return n;
    else
    return fib(n-1) + fib(n-2);
    
    }
      
    
	
	public static void main (String[] args)
    {
		
		int n = 25;
		int myArray [] = new int [n];
		
		for (int i = 0; i < myArray.length ; i++) {
			
			myArray[i] = fib (i);
			System.out.println(fib(i));
			
		}
		
    }
	

}
