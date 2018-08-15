package com.revature.hw1.question10;

import java.util.Scanner;

public class MinOfTwoNums {
	
	static int num1, num2, bigNum;
	
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter First Number:");
	    num1 = scanner.nextInt();
	    System.out.println("Enter Second Number:");
	    num2 = scanner.nextInt();
	    scanner.close();
	    
	    bigNum = (num1 > num2) ? (num1) : (num2);
	    
	    System.out.println("The bigger number is: "+ bigNum);
	}


}
