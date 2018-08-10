package com.revature.q5;

/*
 * Q5. Write a substring method that accepts a string str and an integer 
 * idx and returns the substring contained between 0 and idx-1 inclusive.
 *  Do NOT use any of the existing substring methods in the String, StringBuilder,
 *  or StringBuffer APIs.
 * */
public class Substring {
	public static void main(String[] args) {
		String str = "Revature234";
		//turn string into array
		String arr[] = str. split("");
		
		
		// condition 0 < x <= arr.length
		int x = arr.length;
		
		int begin = 0;
		int end = x;
		
		
		while(end > begin) {
			
			System.out.print(arr[begin]);
			begin++;
		}
		
	}
}
