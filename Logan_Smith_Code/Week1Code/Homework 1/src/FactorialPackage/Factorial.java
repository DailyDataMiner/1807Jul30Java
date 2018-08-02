// Logan Smith, 8/2/2018
// Factorial Calculator

package FactorialPackage;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factorial fac = new Factorial(); // Creates instance of calculator

		int size = 7; // Size of factorial
		
		int output = fac.factorialCalculator(size); // output is calculated by the factorial of size
		
		System.out.println(output);

	}

	// Method to find the factorial of a number
	public int factorialCalculator(int size) {
		int output = 1; // Final output
		for (int i = 1; i <= size; i++) { // Loops through the size
			output = output*i; // output is multiplied
		}
		return output; // returns output
	}
}
