package com.revature.q12;

import java.util.ArrayList;

public class Question12 {

	public static void main(String[] args) {

		ArrayList<Integer> ar = new ArrayList<Integer>();
//add 1-100 into ArrayList
		for (int i = 1; i <= 100; i++) {
			ar.add(i);
		}
//if the number has no remainder when divided then print it out
		for (int i : ar) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}

	}
}
