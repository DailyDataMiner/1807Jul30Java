package com.revature.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {

	public static void main(String[] args) {
		int[] nums = {9,5,2,10};
		int[] n = new int [5];
		//n[10] = 7; //outofboundsexception
		/*int[] wront = new int[]; //in order to declare an array, we must either explicitly add its values
		 * or specify the size we want to allocate it.
		 */
	
		int length = nums.length;
		int[][] twoD = new int[4][4];
	 	twoD[0][0] = 'x';
	 	twoD[0][1] = 1;
	 	twoD[1][0] = 1;
	 
	 
	 	for (int i=0; i < twoD.length; i++) {
		 	for (int j = 0; j < twoD[i].length; j++) {
		 		System.out.print(twoD[i][j]);
		 	}
	 	} 	System.out.println();
	
	System.out.println(Arrays.toString(nums));
	//System.out.println (add());
	//ystem.out.println(add(1, 29584, 34, 15));
	//System.out.println(add(10, 10, 3, 5, 7, 9));)
	
	//var args
	//can only have one per param list. and must be last param in list
	
	}
}