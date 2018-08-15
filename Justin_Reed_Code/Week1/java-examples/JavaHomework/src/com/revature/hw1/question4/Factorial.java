package com.revature.hw1.question4;

import java.util.InputMismatchException;
import java.util.Scanner;

// factorial operation is n! = (n-1)!
//This can be represented by  a recursive function
public class Factorial {
	
	
	static int factorial(int num) {
		
		
		// 0! = 1, so if 0 return 1 and 
		//if not return recursive function
		if (num != 0) {
			
			return (num*factorial(num-1));
			
		}
		else
		return 1;
		
	}
		
			 
	public static void main(String[] args) {
		
		int num = 1;
		
		System.out.println("Please Enter a number: ");
		
		try {
			Scanner scan = new Scanner(System.in);
			num = scan.nextInt();
			scan.close();
			
		}catch (InputMismatchException ime){
			ime.printStackTrace();
			System.out.println("Please Enter a valid number");
			
			
		}
		
		
		System.out.println("The factorial of "+num +" is "+factorial(num));
	}
	

}
