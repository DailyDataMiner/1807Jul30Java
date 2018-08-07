package com.revature.week1.Q14;

import java.util.Date;

public class Switch {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			switch (i) {
			case 1:
				final int n = 144;
				System.out.println(Math.sqrt(n));
				break;
			case 2:
				System.out.println(new Date());
				break;
			case 3:
				String str = "I am learning Core Java";
				String[] strArr = str.split(" ");
				for (String s : strArr) {
					System.out.println(s);
				}
				break;
			}
		}
	}

}
