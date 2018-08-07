package com.revature.week1.Q1;

import java.util.Arrays;

public class SortingAlgorithms {

	private static int[] bubbleSort(int[] arr) {
		for(int temp, j = arr.length - 1; j > 0; j--) {
			for(int i = 0; i < j; i++) {
				if(arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	private static int[] quickSort(int[] arr) {
		int temp, separator = 0, last = arr.length - 1;
		if(last < 1) {return arr;}
		// Choose a pivot randomly, then swap it with the last element
		final int rand = (int) (Math.random() * arr.length - 1);
		temp = arr[rand];
		arr[rand] = arr[last];
		arr[last] = temp;
		// Push values smaller than the pivot to the left, larger to the right
		for(int i = 0; i < last; i++) {
			if(arr[i] < arr[last]) {
				temp = arr[i];
				arr[i] = arr[separator];
				arr[separator] = temp;
				separator++;
			}
		}
		// Separate left and right sub-arrays
		final int[] left = Arrays.copyOfRange(arr, 0, separator);
		final int[] right = Arrays.copyOfRange(arr, separator, last);
		// Recursive Quicksorts on left array and right array
		System.arraycopy(quickSort(left), 0, arr, 0, left.length);
		arr[left.length] = arr[last];
		System.arraycopy(quickSort(right), 0, arr, left.length + 1, right.length);
		return arr;
	}
	
	//Iterates through an int array and print each element to standard output
	private static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	//test driver
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.print("Unsorted:    ");
		printArray(arr);
		System.out.print("Bubble Sort: ");
		printArray(bubbleSort(arr));
		System.out.print("Quick Sort:  ");
		printArray(quickSort(arr));
	}

}
