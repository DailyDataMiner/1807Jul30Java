package Q14;

import java.util.Date;

public class caseTester {
	
	public static void main(String[] args) {
		
		oneOfThree(3);
		
	}
	
	public static void oneOfThree(int n) {
		
		switch(n) {
		case 1: 
			System.out.println("The square root of 10 is " + Math.sqrt(10));
		break;
		
		case 2: 
			// Instantiate a Date object
			Date date = new Date();
			// display time and date using toString()
			System.out.println("today's date is: " + date.toString());
		break;
		
		case 3:
			String coreJava = "I am learning Core Java";
			String[] coreArray = coreJava.split(" ");
			
			for (String s : coreArray) {
				System.out.println(s);
			}
		break;
		
		default:
			break;
		}
		
	}
	
}
