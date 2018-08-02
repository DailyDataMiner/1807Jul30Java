// Logan Smith, 8/2/2018
// Class to print all even numbers from 1-100

package EvenPrintPackage;

public class EvenPrint {

	public static void main(String[] args) {
		
		EvenPrint evenPrint = new EvenPrint(); // Instance to get access to methods
		int[] hundred = new int[100]; // Array of ints
		
		evenPrint.fillHundred(hundred); // Fills array of ints from 1-100
		evenPrint.printEven(hundred); // Prints out all even numbers from 1-100
		

	}

	// Function to fill an array with numbers 1-100
	public void fillHundred(int[] hundred) {
		for (int i = 0; i < 100; i++) {
			hundred[i] = i+1;
		}
	}
	
	// Function to print out all even numbers in an array
	public void printEven(int[] hundred) {
		for (int i : hundred) { // Enhanced for loop through array 
			if (i%2 == 0) { // checks if even
				System.out.println(i); // prints out all even numbers
			}
		}
	}
	
}
