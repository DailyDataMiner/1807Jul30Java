// Logan Smith, 8/2/2018
// Class to determine what numbers are prime in a list from 1-100

package PrimeNumberPackage;

import java.util.ArrayList;

public class PrimeNumberFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrimeNumberFinder pnf = new PrimeNumberFinder(); // Creating instance to reference functions
		
		ArrayList<Integer> hundred = new ArrayList<Integer>(); // General list from 1-100
		hundred = pnf.toHundred(hundred); // Fills arraylist
		pnf.outputPrime(hundred); // Ouputs prime numbers
	}
	
	// Function to fill arraylist with integers 1-100
	private ArrayList<Integer> toHundred(ArrayList<Integer> hundred) {
		for (int i = 1; i <= 100; i++) {
			hundred.add(i);
		}
		
		return hundred;
	}
	
	// Function to print all prime numbers between 1-100
	public void outputPrime(ArrayList<Integer> hundred) {
		
		for (Integer i : hundred) { // loops through arraylist of integers
			if (isPrime(i)) { // references isPrime function to determine if number is prime
				System.out.println(i);
			}
		}
		
	}
	
	// Function to determine if a number is prime. Outputs true if the number is prime, false if not.
	private boolean isPrime(Integer i) {
		
		for (int a = 2; a < i; a++) { // loops through all possible numbers
			if (i%a == 0) { // Determines if number is a product of another
				return false; // If so, the number cannot be prime
			}
		}
		
		return true;
	}

}
