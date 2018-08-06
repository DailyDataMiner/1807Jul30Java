package Q17;

import java.util.Scanner;

public class simpleInterest {

	public static void main(String[] args) {
		
		System.out.print("Please enter the principal amount: ");
		Scanner principal = new Scanner(System.in);
		double p = principal.nextDouble();
		System.out.println("principal amount is: " + p + " dollars");

		System.out.print("Please enter the interest rate: ");
		Scanner rate = new Scanner(System.in);
		double r = rate.nextDouble();
		System.out.println("rate is: " + r + " percent");
		
		System.out.print("Please enter the number of years: ");
		Scanner time = new Scanner(System.in);
		double t = principal.nextDouble();
		System.out.println("time is: " + t + " years");
		
		calculateInterest(p, r, t);
		
	}

	public static void calculateInterest(double i, double j, double k) {
		
		double interest = i * j * k;
		System.out.println("\n" + "the interest is: " + interest);
		
	}
	
}
