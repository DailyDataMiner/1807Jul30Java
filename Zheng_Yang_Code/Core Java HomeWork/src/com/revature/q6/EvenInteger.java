package com.revature.q6;

import java.util.jar.Attributes.Name;

import javax.security.auth.callback.NameCallback;

/*
 * Q6. Write a program to determine if an integer is 
 * even without using the modulus operator (%)
 * */
public class EvenInteger {
	public static void main(String[] args) {
		
		//input 
		int input = 10; 
		
			if((input*2) > (input/2*4)) {
				System.out.println(input + " is odd");
			} else {
				System.out.println(input + " is even");
			}
			
		    
		
	}
}
