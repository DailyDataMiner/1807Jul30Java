package com.revature.q11part1;

import com.revature.q11part2.AnotherPackageQuestionClass;

/**
 * Shows how to get variables from another package
 * 
 * @author Arthur Panlilio
 *
 */
public class AnotherPackageQuestion {

	public static void main(String[] args) {
		//Creates an instance of the other class and gets the variables in it, since they are protected so this main must use a getter. 
		AnotherPackageQuestionClass a = new AnotherPackageQuestionClass(3, 5);
		System.out.println(a.getX1() + " " + a.getX2());
	}

}
