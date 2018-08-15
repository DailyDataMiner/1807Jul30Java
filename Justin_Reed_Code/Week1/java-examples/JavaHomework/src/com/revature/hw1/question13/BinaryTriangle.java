package com.revature.hw1.question13;

public class BinaryTriangle {
	
	/*
	 * In order to create a binary triangle we need two for loops.
	 * One to alternate between 0 and 1, and another to skip to the next line. 
	 */
	
	 public static void main(String[] args) {
	      
	       int count = 1;
	       for (int i=1;i<=4;i++){
	    	   //having j<i insures we never too many 0's and 1's 
	           for (int j=0;j<i;j++){
	               if (count%2!=0) {
	                   System.out.print("0");
	               }
	               else {
	                   System.out.print("1");
	               }
	               count++;
	           }
	           System.out.print("\n");
	       }  
	   }

}
