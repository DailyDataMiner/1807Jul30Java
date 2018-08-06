package com.revature.q19;
import com.revature.helpers.HelperFunctions;

import java.util.ArrayList;
//import java.util.Iterator;

/**
 * Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
	the even numbers up and display the result. Add all the odd numbers up and display the
	result. Remove the prime numbers from the ArrayList and print out the remaining
	ArrayList.
 * @author omaracevedoacevedo
 *
 */

public class ArrayListNumbers extends HelperFunctions {

	public static void main(String[] args) {
		
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		for ( int i = 1; i <= 10; i++ ) {
			intArr.add(i);
		}
		
//		println(intArr.iterator());
		
		println(intArr.toString());
		
		for (Integer intIter : intArr) {
			println(intIter);
		}
		
	}

}
