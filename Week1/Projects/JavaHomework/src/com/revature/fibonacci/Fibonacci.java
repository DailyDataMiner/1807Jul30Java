package com.revature.fibonacci;

import java.io.*;
import java.util.ArrayList;


public class Fibonacci {

	// first 25 fibonacci numbers starting at 0
	public static void main(String[] args) {
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(0);
		arrlist.add(1);
		
		for (int i=0; i<23; i++) {
			arrlist.add(arrlist.get(i) + arrlist.get(i+1));
		}
		System.out.println(arrlist.toString());
	}

}
