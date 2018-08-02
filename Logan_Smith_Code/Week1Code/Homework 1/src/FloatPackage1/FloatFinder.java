// Logan Smith, 8/2/2018
// Finds the two floats hiding in the other float package

package FloatPackage1;

import FloatPackage2.FloatHider; // imports the FloatHider class from FloatPackage2

public class FloatFinder {

	public static void main(String[] args) {
		
		System.out.println(FloatHider.a + " " + FloatHider.b); // Finds the variables in the FloatHider and outputs them

	}

}
