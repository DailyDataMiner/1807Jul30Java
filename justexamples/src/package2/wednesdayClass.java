package package2;

import java.util.Scanner;

public class wednesdayClass {
	
//	public void fibonacci(int n) {
//		int x = 0;
//		int y = 1;
//		
//		if () {
//			
//		}
//	}
	
	public static void main(String[] args) {
		
//		System.out.println("enter 10 grades: ");
//		Scanner bait = new Scanner(System.in);
//		int total = 0;
//		int grade;
//		int average;
//		int counter = 0;
//		while(counter < 10) {
//			grade = bait.nextInt();
//			total = total + grade;
//			counter++;
//		}
//		average = total/counter;
//		System.out.println("Your average is " + average);
		
		double amount;
		double principal = 10000;
		double rate = .01;
		
		for (int day = 1; day <= 20; day++) {
			amount = principal * Math.pow(1+rate,  day);
			System.out.println(day + "   " + amount);
		}
		
	}

}
