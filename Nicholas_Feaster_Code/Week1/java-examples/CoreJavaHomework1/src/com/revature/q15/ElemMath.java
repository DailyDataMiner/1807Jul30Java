package com.revature.q15;

public class ElemMath {
 public static void main(String[] args) {
	int west = 143;
	int east = 7;
	
	Mixer q = new Mixer();
	System.out.println(q.addition(west, east));
	System.out.println(q.subtraction(west, east));
	System.out.println(q.mult(west, east));
	System.out.println(q.div(west, east));
 }
}
