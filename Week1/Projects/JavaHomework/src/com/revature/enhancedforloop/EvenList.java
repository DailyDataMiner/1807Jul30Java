package com.revature.enhancedforloop;

public class EvenList {

	
	
	
	public static void main(String[] args) {
		
		int[] array = new int[100];
		for (int i=0; i<100; i++) {
			array[i] = i+1;
		}
		
		for(int i=0; i<array.length; i++) {
			if (array[i] % 2 == 0) {
				System.out.println(array[i]);
			}
		}

	}

}
