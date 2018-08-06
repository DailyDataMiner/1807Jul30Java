package com.revature.bubblesort;

import java.util.Arrays;

public class BubbleSort {
	
	//sorts by swapping values after comparison after each pass; this method might not be as efficient for larger lists
	public static void main(String[] args) {
		
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};
		int x;
		int y;
		boolean swap;
		
			do {
			swap = false;
				for (int i = 0; i <list.length-1; i++) {
					x = list[i];
					y = list[i+1];
					if (x > y) {
						list[i] = y;
						list[i+1] = x;
						swap = true;
					}
				}
			}while (swap == true);
			
		
		
		System.out.println(Arrays.toString(list));
	}
}
	
		
	
