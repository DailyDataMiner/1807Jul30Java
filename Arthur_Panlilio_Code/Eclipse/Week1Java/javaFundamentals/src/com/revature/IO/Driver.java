package com.revature.IO;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	static IODAO dao = new IODAO();

	public static void main(String[] args) {
		Student s = new Student("Patrick Walsh", "pjwalsh@revature.com", 85);
		//System.out.println(s.toString());
		String a = "5" + 8;
		System.out.println(a);
		//dao.addStudent(s);
		
		//viewStudents();
	

	}
	
	static void viewStudents() {
		List<Student> students = dao.readStudents();
		for(Student s: students) {
			System.out.println(s);
		}
	}

}
