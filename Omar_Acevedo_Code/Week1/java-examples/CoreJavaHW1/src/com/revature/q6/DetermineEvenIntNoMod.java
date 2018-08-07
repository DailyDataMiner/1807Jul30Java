package com.revature.q6;
import java.util.Scanner;

import com.revature.helpers.HelperFunctions;

// Q6. Write  a program  to  determine  if  an  integer is  even  without  using  
// the  modulus operator (%).

public class DetermineEvenIntNoMod extends HelperFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] evenNumbers = { 0, 2, 4, 6, 8 };
		
		Scanner scan = new Scanner(System.in);
		
		print("Enter an integer: ");
		int n = scan.nextInt();		
		
//		if ( ( (n / 2) * 2 ) == n ) {
//			print(n + " is an even number.");
//		} else 
//			print(n + " is an odd number.");
		
		println( ( evenNumber(n) ) ? n + " is an even number." : n + " is an odd number." );
		
	}
	
	public static boolean evenNumber(int n) {
		return ( ( (n / 2) * 2 ) == n );
	}

}
