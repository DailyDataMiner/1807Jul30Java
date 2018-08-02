package com.revature.q1;
import com.revature.helpers.HelperFunctions;

// Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

public class ABubbleSort extends HelperFunctions {
	public static void main(String[] args) {
		int[] intArr = {1,0,5,6,3,2,3,7,9,8,4};
		int tempVar;
		for (int i=0; i<intArr.length-1; i++) {
//			for (int j=intArr.length-1; j) {
				if ( intArr[i] > intArr[i+1] ) {
					tempVar = intArr[i+1];
					intArr[i+1] = intArr[i];
					intArr[i] = tempVar;
				}
//			}
			
		}
		for (int i=0; i<intArr.length-1; i++) {
			print(intArr[i] + ", ");
		}
	}
}
