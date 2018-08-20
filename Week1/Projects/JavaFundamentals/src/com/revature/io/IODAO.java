package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class IODAO {
	//class used to read from and write to text file
	
	void addStudent(Student student) {
		//name;email;grade
		
		//BufferedWriter
		//FileWriter
		
		/* Try with Resources
		 * Parameterized try block used with classes that
		 * implement the AutoCloseable interface so that 
		 * you don't need a finally block to close your
		 * resource after using it
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("JavaFundamentals/src/com.revature.io.files/students.txt"));) {
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//List<Student> readStudents(){
			
		
		
		
	}
}
