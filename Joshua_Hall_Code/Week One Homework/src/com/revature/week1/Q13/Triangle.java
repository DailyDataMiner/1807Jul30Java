package com.revature.week1.Q13;

import java.util.ArrayList;

public class Triangle {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			list.add(i % 2);
			for(int j : list) {
				System.out.print((i % 3 == 0? j : 1-j) + " ");
			}
			System.out.println();
		}

	}

}
