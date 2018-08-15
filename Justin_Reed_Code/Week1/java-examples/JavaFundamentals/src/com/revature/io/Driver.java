package com.revature.io;

import java.util.List;

public class Driver {
	
	static IODAO dao = new IODAO();
	public static void main(String[] args) {
		Student s = new Student("Patrick Walsh", "pjwalsh@revature", 85);
				System.out.println(s);
		
				
		
		dao.addStudent(s);
		
	}
	
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s : students ) {
			System.out.println(s.getName());
		}
	}
}
