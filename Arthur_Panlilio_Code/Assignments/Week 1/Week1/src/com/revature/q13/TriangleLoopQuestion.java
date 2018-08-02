package com.revature.q13;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Prints a triangle of 1's and 0's
 * 
 * @author Arthur Panlilio
 *
 */
public class TriangleLoopQuestion {

	public static void main(String[] args) {
		//executes the triangle printer
		triangleMaker();
	}
	
	public static void triangleMaker() {
		//Populates an array with 1's and 0's
		int[] arr = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
		//counters for making new lines
		int orig = 1;
		int count =1;
		//iterates through the array
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			//Count subtracts by 1 each loop, if 0 executes new line and gets a higher value
			count--;
			if (count <= 0) {
				System.out.println();
				orig++;
				count = orig;
			}
			
		}
	}

}
