package com.revature.IO;

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
		// name;email;grade

		// BufferedWriter
		// FileWriter

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Files/students.txt", true));) {
			bw.write(student.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	List<Student> readStudents() {
		List<Student> s = new ArrayList();
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/Files/students.txt"))){
			String line = null;
			while((line=br.readLine()) != null) {
				String[] studentInfo = line.split(";");
				Student temp = new Student(studentInfo[0], studentInfo[1], Double.parseDouble(studentInfo[2]));
				System.out.println(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s;
	}

}
