// Logan Smith, 8/2/2018
// Class to perform operations with an ArrayList

package ArrayListDisplayPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDisplay {

	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>();

		// Fills list
		for (int i = 1; i <= 10; i++) {
			intList.add(i);
		}
		// Displays list
		for (Integer i : intList) {
			System.out.print(i + " ");
		}
		System.out.println();
		int evenTotal = 0;
		int oddTotal = 0;
		for (Integer i : intList) { // loops through list
			if (i % 2 == 0) { // if i is even
				evenTotal = evenTotal + i; // add it to the even total
			} else {
				oddTotal = oddTotal + i; // else, add it to the odd total
			}
		}
		// Display
		System.out.println("Even Total: " + evenTotal);
		System.out.println("Odd Total: " + oddTotal);

		Iterator<Integer> itInt = intList.iterator(); // Create an iterator for the list

		while (itInt.hasNext()) { // Continues until it runs out of options
			int i = itInt.next(); // gets the current integer
			boolean remove = true; // remove will tell us if it is prime
			for (int a = 2; a < i; a++) { // loops through all possible numbers
				if (i % a == 0) { // Determines if number is a product of another
					remove = false; // if it is prime, do not remove
				}
			}
			if (remove == true) { // if is prime, remove
				itInt.remove();
			}
		}
		for (Integer i : intList) {
			System.out.print(i + " ");
		}

	}

}
