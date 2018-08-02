package com.revature.io;
import java.util.List;

import com.revature.helpers.HelperFunctions;

public class Driver extends HelperFunctions {

	static IODAO dao = new IODAO();
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Omar Acevedo", "omar@mail.com", 99.50);
		Student student2 = new Student("Ramo Odeveca", "ramo@mail.com", 89.10);
//		print(s.toString());
		
		dao.addStudent(student1);
		dao.addStudent(student2);

		viewStudents();
		
	}
	
	private static void viewStudents() {
		List<Student> students = dao.readStudents();
		for (Student s : students) {
			print(s.getName());
			
		}		
	}
	
}
