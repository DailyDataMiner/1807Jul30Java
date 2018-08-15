package com.revature.hw1.question14;

import java.util.Date;
import java.util.Scanner;

public class CaseStudy {
	  public static void main(String[] args) {
		  
		  System.out.println("Enter Number between 1 to 3");
	      Scanner scan = new Scanner(System.in);
	       
	      int number = scan.nextInt();
	      double num = 69;
	      switch (number) {
	      
	      
	           case 1:            
	               num = Math.sqrt(num);
	               System.out.println("Square Root: "+num);
	               break;
	           case 2:
	               Date date = new Date();
	               System.out.println("Todays Date: "+date);
	               break;          
	           case 3:
	               String str = "I am Learning Core Java";
	               String strArray [] = str.split(" ");
	               for (String j:strArray) {
	                   System.out.println("String Array Value: "+j);
	               }
	               break;
	           	   default: System.out.println("Please choose a valid number");
	               break;
	       }
	   }
	}