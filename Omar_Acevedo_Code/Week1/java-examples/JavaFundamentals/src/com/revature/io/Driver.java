package com.revature.io;
import com.revature.helpers.HelperFunctions;

public class Driver extends HelperFunctions {

	public static void main(String[] args) {
		
		Student s = new Student("Omar Acevedo", "omar@mail.com", 99.50);
//		print(s.toString());
		print(s);
		
		IODAO dao = new IODAO();
		dao.addStudent(s);
		
	}

}
