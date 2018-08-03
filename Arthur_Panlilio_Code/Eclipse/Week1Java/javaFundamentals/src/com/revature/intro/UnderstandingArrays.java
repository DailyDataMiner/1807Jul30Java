package com.revature.intro;

import java.util.Arrays;

public class UnderstandingArrays {

	public static void main(String[] args) {
		
		int[] nums = {9, 5, 2, 10};
		int[] n = new int[5];
		//n[10] = 7;
		//int wrong = new int[];
		
		int length  = nums.length;
		int[][] twoD = new int[4][4];
		twoD[0][0] = 0;
		twoD[0][1] = 1;
		twoD[1][0] = 1;
		
		for(int i = 0; i < twoD.length; i++) {
			for(int j = 0; j < twoD[i].length; j++) {
				System.out.print(twoD[i][j]);
			}
			System.out.println();
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(add());
	}
	
	//var args
	static int add(int... nums) {
		int sum = 0;
		for(int n:nums) {
			sum+=n;
		}
		return sum;
	}

}