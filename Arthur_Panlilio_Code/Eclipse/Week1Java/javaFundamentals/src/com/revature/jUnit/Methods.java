package com.revature.jUnit;

public class Methods {

	public int[] bubbleSort(int[] nums) {
		//Gets the length for the array and loops through the array once
				int l = nums.length;
				for(int i = 0; i < l; i++) {
					//Starts looping at the second index and looks at the index behind it. N^2 worst run time, if n is length
					for(int q = 1; q < l - i; q++) {
						//If the value at index-1 is bigger than the value in index, swap their places
						if(nums[q - 1] > nums[q]){
							//Use a temporary variable to swap values
							int x = nums[q - 1];
							nums[q - 1] = nums[q];
							nums[q] = x;
						} 
					}
				}
				return nums;
	}
	
	public String reverseString(String str) {
		return str;
	}
	
	public int factorial(int n) {
		return n;
	}
}
