package com.revature.q1;

public class Question1 {
	
	public static void bubblesort(int ar[]) {
//uses nested for loops to sort array
		//if the previous value is greater than the next
		//swap the values
		for(int a = 0 ; a < ar.length-1; a++) {
			for (int b = 0; b < ar.length-1; b++ ) {
				if (ar[b] > ar[b+1]) {
					int temp = ar[b+1];
					ar[b+1] = ar[b];
					ar[b] = temp;
				}
			}
			
		}
		for(int c = 0; c < ar.length; c++)
		System.out.println(ar[c]);
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		bubblesort(arr);
		
	}

}
