package com.revature.q12;

public class Even {

	public static void main(String[] args) {
		// create an array of integers between 1 and 100
		int nums[] = new int[100];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
		// for each integer in the array, print the even numbers to the console
		for(int num : nums) {
			if(nums[num] % 2 == 0) {
				System.out.print(nums[num] + " ");
			}
		}
	}

}
