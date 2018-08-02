package com.revature.io;

import java.util.List;

public class Driver {
	static IODAO dao = new IODAO();
	public static void main(String[] args) {
		
		Student s = new Student("Ryan Posey", "rkposey86@gmail.com", 100.00);
		//System.out.println(s);
		
		IODAO dao = new IODAO();
		//dao.addStudent(s);
		
		viewStudents();
		
	}
	
	static void viewStudents() {
		
		List<Student> students = dao.readStudents();
		for(Student s : students) {
			System.out.println(s.getName());
		}
 	}

}
