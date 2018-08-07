package com.revature.q1;
/*
 * Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 * BubbleSort implementation in Arrays
 * */
public class Q1_BubbleSort {
	public static void main(String[] args) {
		
		int arr[]= {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(arr);
		
		
		print(arr);
		
		
	}
	
	/*
	 * use two for loops constantly swapping adjacent elements
	 * if they are in wrong order
	 * */
	public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
	
	public static void print(int arr[] ) {
		for(int i = 0; i < arr.length; i++ ) {
			System.out.println(arr[i]);
		}
	}
	
}
