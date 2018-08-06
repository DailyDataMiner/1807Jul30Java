package homework1.q17;

import static java.lang.System.in;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		//Creates new instance of Scanner to read in from console and then reads next 3 integers from user
		Scanner scan = new Scanner(in);
		System.out.println("Please enter number for Principal: ");
		int principal = scan.nextInt();
		
		System.out.println("Now enter number for rate: ");
		int rate = scan.nextInt();
		
		System.out.println("Finally enter number for time: ");
		int time = scan.nextInt();
		
		scan.close();
		
		//Multiplies all values from console user and displays result
		int interest = principal * rate * time;
		System.out.println("Your interest from the numbers provided is: " + interest);

	}

}
