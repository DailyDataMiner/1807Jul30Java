package com.revature.controlstatements;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class loopsandstatements {
	
	



public static void main(String[] args ) {
	Random rand = new Random();

	
	int myArray[] = new int[10];
	
	/*
	//fill array with random numbers 
	for(int i =0; i<myArray.length; i++) {
		
		int n = rand.nextInt(20) + 1;
		myArray[i] = n;
	
		
	}
	
	//check to see if numbers are even or odd
	for (int i = 0; i < 10; i++) {
		if (myArray[i] % 2 == 0) {
		System.out.print(myArray[i]);
		System.out.println(" : this number is even");
		}
		else if (myArray[i] % 2 != 0) {
			System.out.print(myArray[i]);
			System.out.println(" : this number is odd");	
		}
	}*/
	
	//print only 1 through 5
	
    
	for (int i =0; i<myArray.length; i++) {
		
		int n = rand.nextInt(15) + 1;
		myArray[i] = n;
		System.out.println(myArray[i]);
		}
	System.out.println();
	for (int i =0; i<myArray.length; i++)
	{
		
		switch (myArray[i]) {
		
		
		case 1: System.out.println(myArray[i]);
				break;
		case 2: System.out.println(myArray[i]);
				break;
		case 3: System.out.println(myArray[i]);
				break;
		case 4: System.out.println(myArray[i]);
				break;
		case 5: System.out.println(myArray[i]);
				break;
		case 6: System.out.println(myArray[i]);
				break;
		case 7: System.out.println(myArray[i]);
				break;
		case 8: System.out.println(myArray[i]);
				break;
		case 9: System.out.println(myArray[i]);
				break;
		case 10: System.out.println(myArray[i]);
				break;
		default: System.out.println("Number is too big");
			break;
		}
		
		
    }
    
	
	


	
	
	
	
	
}}