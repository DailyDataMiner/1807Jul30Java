package com.revature.q14;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Uses a switch case method to do different things
 * 
 * @author Arthur Panlilio
 *
 */
public class SwitchQuestion {

	public static void main(String[] args) {
		switcher(1);
		switcher(2);
		switcher(3);

	}
	/**
	 * Does three things depending on the integer sent in
	 * It can find the square root of 25, get the time, and split a string
	 * 
	 * @param int n decides what will happen
	 */
	public static void switcher(int n) {
		switch(n){
			case 1:
				System.out.println("The square root of 25 is: " + Math.sqrt(25.00) + "!");
				break;
			case 2:
				SimpleDateFormat df =  new SimpleDateFormat("yyyy-mm-dd");
				System.out.println(df.format(new Date()));
				break;
			case 3:
				String s = "I am learning Core Java";
				String[] arr = s.split("\\s");
				for(int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				break;
		}
	}

}
