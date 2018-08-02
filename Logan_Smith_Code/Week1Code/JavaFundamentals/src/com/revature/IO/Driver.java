package com.revature.IO;

public class Driver {

	public static void main(String args[]) {
		Student s = new Student("Bri", "megareeee@gmail.com", 7.5);
		//System.out.println(s);
		
		IODAO dao = new IODAO();
		dao.addStudent(s);
	}
}
