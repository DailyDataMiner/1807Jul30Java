// Logan Smith, 8/2/2018
// Simple class showing off ternary operator, used to find a minimum between two numbers

package question10;

public class FindingMinimumWithTernary {

	public static void main(String[] args) {
		FindingMinimumWithTernary fmwt = new FindingMinimumWithTernary(); // Creating instance to reference functions
		
		int a = 18; // Option A
		int b = 12; // Option B
		
		System.out.println("Minimum Number: " + fmwt.findingMinimum(a, b));
		

	}
	
	// Function to find the minimum between two number inputs. Returns the smaller number.
	public int findingMinimum(int a, int b) {
		return a < b ? a : b; // Uses ternary to compare a to b, and return the appropriate number. Pretty simple.
	}

}
