package com.revature.q17;

import java.util.Scanner;

public class Question17 {

	
		public static void main(String[] args) {
			//creates scanner and inputs values
			System.out.println("Enter Principle: ");
			Scanner scp = new Scanner(System.in);
			double principle = scp.nextDouble();
			
			
			System.out.println("Enter Rate: ");
			Scanner scr = new Scanner(System.in);
			double rate = scr.nextDouble();
			
			System.out.println("Enter Time: ");
			Scanner sct = new Scanner(System.in);
			double time = sct.nextDouble();
			//THIS IS NOT A REAL INTEREST FORMULA
			double Interest = principle * rate * time;
			
			System.out.println(Interest);
			//closes scanner
			scp.close();
			scr.close();
			sct.close();


			
			
		}
}
