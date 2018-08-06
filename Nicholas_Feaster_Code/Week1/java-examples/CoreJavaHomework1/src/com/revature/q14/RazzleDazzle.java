package com.revature.q14;

import java.time.LocalDateTime;

public class RazzleDazzle {
	public static void main(String[] args) {

	int casing = Integer.parseInt(args[0]);
	int oneNum = Integer.parseInt(args[1]);
	String input = "I am learning Core Java";
	switch (casing) {
	case 1 : double slice;
		System.out.println(slice = Math.sqrt(oneNum));
		break;
	case 2 : System.out.println(LocalDateTime.now());
		break;
	case 3 : String[] words = input.split(" ");
		System.out.println("String successfully split");
	}
}
}
