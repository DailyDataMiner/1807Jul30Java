package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IODAO {
	
//	This will be a utility class
//	Class used to read from and write to text file
	
	void addStudent(Student p_student) {
		// Format -> name;email;grade
		
		// BufferedWriter
		// FileWriter
		
		// TRY WITH RESOURCES
		// Parameterized try block used with classes that implement the the AutoCloseable 
		// interface so that your do not need a finally block to close your resource 
		// after using it.
		try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("src/files/students.txt", true));) {
			
			bw.write(p_student.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	List<Student> readStudents() {
		List<Student> s = new ArrayList<Student>();
		return null;
	}
	
}
