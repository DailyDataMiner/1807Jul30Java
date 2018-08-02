package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		List<Student> studentList = new ArrayList<Student>();
		
		try (BufferedReader br = new BufferedReader(
				new FileReader("src/files/students.txt"));) {
			String line = null;
			while ( ( line = br.readLine() ) != null) {
				String[] studentInfo = line.split(";");
				Student newStudent = new Student();
				newStudent.setName(studentInfo[0]);
				newStudent.setEmail(studentInfo[1]);
				newStudent.setGrade(Double.parseDouble(studentInfo[2]));
				studentList.add(newStudent);
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
//		return null;
	}
	
}
