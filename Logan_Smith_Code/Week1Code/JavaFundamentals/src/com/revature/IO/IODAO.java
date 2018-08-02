package com.revature.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

}
