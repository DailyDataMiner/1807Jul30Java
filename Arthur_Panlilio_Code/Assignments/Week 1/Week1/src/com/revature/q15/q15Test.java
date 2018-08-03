package com.revature.q15;

public class q15Test {
	
	public static void main(String[] args) {
		int x = 5;
		int y = 3;
		//Creates an instance of the class that  implements the interface
		q15Class q = new q15Class();
		//Shows the product of x and y.
		System.out.println(q.addition(x, y));
		System.out.println(q.subtraction(x, y));
		System.out.println(q.multiplication(x, y));
		System.out.println(q.division(x, y));
	}

}
