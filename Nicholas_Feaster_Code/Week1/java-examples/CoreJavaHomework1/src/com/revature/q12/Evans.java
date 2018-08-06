package com.revature.q12;

import java.util.ArrayList;

public class Evans {

	public static void main(String[] args) {
		Integer[] transfer = {101};
		ArrayList<Integer> firsty = new ArrayList<Integer>();
		for(int i =1; i<=100;i++) {
			firsty.add(i);
			
		}
		transfer = firsty.toArray(new Integer[firsty.size()]);
			
		for(int i: transfer) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}

}
