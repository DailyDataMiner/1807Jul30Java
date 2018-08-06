package com.revature.week1q1;

public class bubbleSort {

	static void bubbleSort(int array1[], int arrayLength) {
		int i, temp;
		
		boolean notSorted;
		
		for (i = 0; i < arrayLength - 1; i++) {
			notSorted = false;
			for (int j = 0; j < arrayLength - i - 1; j++) {
				if (array1[j] > array1[j + 1]) {
					
					temp = array1[j];
					array1[j] = array1[j + 1];
					array1[j + 1] = temp;
					notSorted = true;
				}
			}

			if (notSorted == false)
				break;
		}
	}

	public static void main(String[] args) {

		int[] unsortedArray1 = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		System.out.println("Unsorted Array: ");
		for (int i = 0; i < unsortedArray1.length; i++) {
			System.out.println(unsortedArray1[i]);
		}
		
		bubbleSort(unsortedArray1, unsortedArray1.length);
		
		System.out.println("Sorted Array: ");
		
		
		for (int i = 0; i < unsortedArray1.length; i++) {
			System.out.println(unsortedArray1[i]);
		}
		

	}

}
