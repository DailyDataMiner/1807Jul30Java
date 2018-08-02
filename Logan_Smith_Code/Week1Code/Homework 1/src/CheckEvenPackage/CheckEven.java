// Logan Smith, 8/2/2018
// Class to check if a number is even

package CheckEvenPackage;

public class CheckEven {

	public static void main(String[] args) {
		CheckEven ce = new CheckEven(); // Creating object to run checkEven function
		
		int checked = 97; // Number to check if even or not
		
		System.out.println("Checked is even: " + ce.checkEven(checked));

	}
	
	// Function which will return true if the number is even, or false if it is odd
	public boolean checkEven(int check) {
		int storedCheck = check/2; // storedCheck abuses integers being whole numbers. 
		// Once divided and multiplied by two, an even number will be the same, while an odd number will have rounded down
		if (storedCheck*2 != check) {
			return false;
		}
		return true;
	}

}
