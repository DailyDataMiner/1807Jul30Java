package com.revature.q15;

public class Question15 implements MathOp {

	public int addition(int a, int b) {
		return a + b;
	}

	public int subtraction(int a, int b) {
		return a - b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public int division(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		
		Question15 q = new Question15();

		int i = 5;
		int h = 10;

		System.out.println(q.addition(i, h));
		System.out.println(q.subtraction(h, i));
		System.out.println(q.multiplication(i, h));
		System.out.println(q.division(h, i));


	}
}
