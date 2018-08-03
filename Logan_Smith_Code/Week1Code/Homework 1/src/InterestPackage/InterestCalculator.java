// Logan Smith, 8/2/2018
// Class to find interest using a Scanner

package InterestPackage;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String args[]) {
		
		System.out.println("Interest Calculator!");
		System.out.println("Please enter your Principle: ");
		Scanner scan = new Scanner(System.in); // Creates a scanner
		int principle = scan.nextInt(); // reads the principle
		System.out.println("Please enter your Rate: ");
		int rate = scan.nextInt(); // reads the rate
		System.out.println("Please enter your Time: ");
		int time = scan.nextInt(); // reads the time
		int interest = principle*rate*time; // calculates time
		System.out.println("Your interest is: " + interest);
		scan.close(); // closes the scanner
	}
	
}
