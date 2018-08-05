package com.revature.q19;

import java.util.ArrayList;

public class ArrayListStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			nums.add(i);
		}
		System.out.println(nums.toString());
		
		int evenSum = 0;
		for(Integer i : nums) {
			if(i % 2 == 0) {
				evenSum += i.intValue();
			}
		}
		System.out.println("The sum of the even numbers: " + evenSum);
		
		int oddSum = 0;
		for(Integer i : nums) {
			if(i % 2 == 1) {
				oddSum += i.intValue();
			}
		}
		System.out.println("The sum of the odd numbers: " + oddSum);
		
		
	}

}
