// Logan Smith, 8/2/2018
// Fibonacci project

package FibonacciPackage;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fibonacci1 = 1; // Will hold the next fibonacci number
		int fibonacci2 = 0; // Will hold the current fibonacci number
		int fibonacci3 = 0; // Will hold the last fibonacci number
		
		int size = 25;
		
		// Loops through dependant on size
		for (int i = 1; i <= size; i++) {
			System.out.print(fibonacci2 + " "); // Prints the current fibonacci number
			fibonacci3 = fibonacci2; // Updates the last fibonacci number
			fibonacci2 = fibonacci1; // Updates the current fibonacci number
			fibonacci1 = fibonacci1+fibonacci3; // Updates the next fibonacci number
		}

	}

}
