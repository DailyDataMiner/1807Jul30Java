package com.revature.q1;

public class BubbleSort {
	// method for sorting an array of integers using a bubble sort algorithm
	public static void sort(int nums[]) {
		int n = nums.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// initialize array
		int[] testNums = {1,0,5,6,3,2,3,7,9,8,4};
		
		//print array to console
		System.out.print("[ ");
		for(int i = 0; i < testNums.length; i++) {
			System.out.print(testNums[i] + " ");
		}
		System.out.println("]");
		
		//sort the array
		sort(testNums);
		
		//print sorted array
		System.out.print("[ ");
		for(int i = 0; i < testNums.length; i++) {
			System.out.print(testNums[i] + " ");
		}
		System.out.println("]");
	}

}