package com.revature.q12;

public class Even {

	public static void main(String[] args) {
		int nums[] = new int[100];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
		
		for(int num : nums) {
			if(nums[num] % 2 == 0) {
				System.out.print(nums[num] + " ");
			}
		}
	}

}
