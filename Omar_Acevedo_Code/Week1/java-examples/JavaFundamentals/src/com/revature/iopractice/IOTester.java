package com.revature.iopractice;
import com.revature.helpers.HelperFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTester extends HelperFunctions {
	
	public void writeFile(Student p_value) {
	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("fileTest.txt", true))) {
		
//			BufferedWriter bw = new BufferedWriter(new FileWriter("fileTest.txt", true));
			
			bw.write(p_value.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void readFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("fileTest.txt"));) {
			
			print(br.readLine());
			print(br.readLine());
			
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}