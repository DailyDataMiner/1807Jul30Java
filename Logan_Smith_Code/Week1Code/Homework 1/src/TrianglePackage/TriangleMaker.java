// Logan Smith, 8/2/2018
// Class to create a triangle with alternating 0s and 1s

package TrianglePackage;

public class TriangleMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TriangleMaker triangleMaker = new TriangleMaker(); // Creates an instance of the class to access functions

		int size = 4; // Size of triangle
		
		triangleMaker.makeTriangle(size); // Creates triangle

	}

	// Function to create the triangle. Loops through size and outputs depending on repeater
	public void makeTriangle(int size) {
		boolean repeater = true; // boolean which switches depending on the last output
		for (int i = 0; i < size; i++) { // loops through size
			for (int j = i; j >= 0; j--) { // loops through current size of i
				if (repeater == true) { // if repeater is true...
					System.out.print(0 + " "); // output 0
					repeater = !repeater; // and switch it
				} else { // if it is false
					System.out.print(1 + " "); // output 1
					repeater = !repeater; // and switch it
				}
			}
			System.out.println(); // new line
		}
	}

}
