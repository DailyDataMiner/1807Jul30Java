package com.revature.q10;
public class ThreeOne {
	public static void main(String[] args) {
		int p1 = Integer.parseInt(args[0]); 
		int p2 = Integer.parseInt(args[1]);
		int mini = p1 > p2? p1:p2;
		System.out.println(mini);
	}
}
