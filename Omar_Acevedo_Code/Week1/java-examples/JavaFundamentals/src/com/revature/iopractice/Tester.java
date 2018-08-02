package com.revature.iopractice;
import com.revature.helpers.HelperFunctions;

public class Tester extends HelperFunctions {

	public static void main(String[] args) {

		Student s1 = new Student("Omar Acevedo", "omar@mail.com", "200-80-5579", 95.43);
		Student s2 = new Student("Ramo Odeveca", "ramo@mail.com", "002-08-9755", 59.34);
		
		IOTester fileTester = new IOTester();
		fileTester.writeFile(s1);
		fileTester.writeFile(s2);
		
		fileTester.readFile();
		
	}
}