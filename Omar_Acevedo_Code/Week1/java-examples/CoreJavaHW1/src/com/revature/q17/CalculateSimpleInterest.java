package com.revature.q17;
import com.revature.helpers.HelperFunctions;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.in;

/**
 * Q17. Write a program that calculates the simple interest on the principal, rate of interest
		and number of years provided by the user. Enter principal, rate and time through the
		console using the Scanner class.
		Interest = Principal* Rate* Time
 * @author omaracevedoacevedo
 *
 */

public class CalculateSimpleInterest extends HelperFunctions {

	public static void main(String[] args) {

		try {
			
			double interest = getInterest();
			println("Your simple interes is the following -> " + interest);
			
		} catch (InputMismatchException ime) {
			
			println("\n----------------------------------");
			println("In order to calculate and get the interest,\nYou should only write numeric characters for the program to work.");
			
		}
		
	}
	
	private static double getInterest() throws InputMismatchException {
		
		Scanner readFromUser = new Scanner(in);
		
		double principal;
		double rate;
		int time; // in years
		
		println("To calculate simple interest on the principal, rate of interest and number of years enter the following: ");
		print("Principal: ");
		principal = readFromUser.nextDouble();

		print("Rate of Interest: ");
		rate = readFromUser.nextDouble();

		print("Number of Years: ");
		time = readFromUser.nextInt();
		
		return (principal * rate * time);
		
	}

}
