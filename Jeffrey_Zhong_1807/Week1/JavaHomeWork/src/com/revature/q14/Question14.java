package com.revature.q14;
import java.time.LocalDate;
public class Question14 {
	
	
	
	
	public static void main(String[] args) {
		//case statement based on int i
		int i = 2;
		double a = 0.0;
		String Java = "I am learning Core Java";
		
		switch(i) {
		case 1: a = Math.sqrt(4);
		System.out.println(a);
		break;
		
		case 2: System.out.println((LocalDate.now()));
		break;
		
		case 3: String [] splitarr = Java.split(" ");
		for(String b : splitarr)
		System.out.println(b);
		break;
		}
		
	}

}
