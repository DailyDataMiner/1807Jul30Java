package com.revature.hw1.question12;

public class EvenArray {
	public static void main(String[] args) {
	      
	       int myArray [] = new int[100];
	      
	       //Storing 1 to 100 in Array
	       for (int i=1;i<= myArray.length;i++) {
	    	   //we must start on i=1 and adjust the index
	    	   //with the code below to aviod 
	    	   //ArrayIndexOutOfBoundsException
	           myArray [i-1] = i;
	       }
	      
	       //Showing Even Number using For Each Loop
	       for (int j:myArray) {
	    	   
	           if(j%2==0)
	        	   
	               System.out.println(j);
	       } 

}
}