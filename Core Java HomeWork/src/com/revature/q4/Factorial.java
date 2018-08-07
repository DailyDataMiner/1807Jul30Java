/**
 * 
 */
package com.revature.q4;

/**
 * 
 * Q4. Write a program to compute N factorial.
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  int i,fact=1;  
		  int number=5;//It is the number to calculate factorial    
		  fact = factorial(number);   
		  System.out.println("Factorial of "+number+" is: "+fact);    
		 
	}
	
	//recursive calling
//	static int factorial(int n){    
//		  if (n == 0)    
//		    return 1;    
//		  else    
//		    return(n * factorial(n-1));    
//	}    
	
	
	static int factorial(int n) {
		
		int total = n; 
		for(int i = 1; i < n; i++) {
			total *=(n-i);
		}
		
		return total; 
	}


}
