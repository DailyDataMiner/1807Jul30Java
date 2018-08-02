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
	// class used to read from and write to text file
	
	void addStudent(Student student) {
		//name;email;grade
		
		//BufferWriter
		//FileWriter
		/*
		 * try with resources
		 * parameterized try block used with classes that implement
		 * the AutoClosable interface so we don't need a final clause
		 * to close resources after using it
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/students.txt"));) {
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	List<Student> readStudents() {
		List<Student> s = new ArrayList<Student>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/files/students.txt"));) {
			String line;
			while((line = br.readLine()) != null) {
				String[] studentInfo = line.split(";");
				Student temp = new Student(studentInfo[0], studentInfo[1], Double.parseDouble(studentInfo[2]));
				s.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
}

