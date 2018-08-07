package com.revature.week1.Q17;

public class SimpleIntrest {

	public static double simpleIntrest(double principal, double roi, int years) {
		return principal * roi * years;
	}
	
	public static void main(String[] args) {
		System.out.println(simpleIntrest(100.00, 0.05, 10));
	}

}
