package com.revature.IO;

import java.util.List;

public class Driver {

	
	static IODAO dao = new IODAO();
	public static void main(String args[]) {
		Student s = new Student("Bri", "megareeee@gmail.com", 7.5);
		//System.out.println(s);
		
		//dao.addStudent(s);
		dao.readStudents();
		
		viewStudents();
	}
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}
}
