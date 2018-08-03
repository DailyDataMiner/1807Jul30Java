package com.revature.q1;

/**
 * Bubble sort example
 * 
 * @author Arthur Panlilio
 *
 */
public class BubbleSortQuestion {

	public static void main(String[] args) {
		int ar[] = {1,0,5,6,3,2,3,7,9,8,4};
		int ar2[] = bubbleSort(ar); //Put array through bubble sort
		printArray(ar2);

	}
	
	/**
	 * This method does the bubble sorting
	 * 
	 * @param ar is the array to be sorted
	 * @return a sorted array
	 */
	public static int[] bubbleSort(int ar[]) {
		//Gets the length for the array and loops through the array once
		int l = ar.length;
		for(int i = 0; i < l; i++) {
			//Starts looping at the second index and looks at the index behind it. N^2 worst run time, if n is length
			for(int q = 1; q < l - i; q++) {
				//If the value at index-1 is bigger than the value in index, swap their places
				if(ar[q - 1] > ar[q]){
					//Use a temporary variable to swap values
					int x = ar[q - 1];
					ar[q - 1] = ar[q];
					ar[q] = x;
				} 
			}
		}
		return ar;
	}
	
	/**
	 * Prints out the array values in order
	 * 
	 * @param ar is the array to be printed
	 */
	public static void printArray(int ar[]) {
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
