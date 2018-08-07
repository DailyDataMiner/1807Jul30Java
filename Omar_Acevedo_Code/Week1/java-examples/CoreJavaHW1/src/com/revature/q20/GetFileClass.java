package com.revature.q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.revature.helpers.HelperFunctions;

/*
 * Q20. Create a notepad file called Data.txt and enter the following:
	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabbit:22:California
	Wonder:Woman:18:Montana
	
	Write a program that would read from the file and print it out to the screen in the
	following format:
	
	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State
 * */

public class GetFileClass extends HelperFunctions {
	
	public static void main(String[] args) {
		
		String file = "src/files/Data.txt";
		
//		createFile(file);
		readFile(file);

	}
	
	private static void readFile(String file) {
		
		String fileValue;  // initialized null by default
		
		// v1
		String[] characterInfo = new String[3];
		
		// v2
		/* Create three variables for each value from .split(":") function and add them to constructor. */
		
		// Read file
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			fileValue = br.readLine();	// Get first line here
			while (fileValue != null) {
				
				String[] fileLineArr = fileValue.split(":");
				
				// name
				characterInfo[0] = fileLineArr[0] + " " + fileLineArr[1];
				
				// age
				characterInfo[1] = fileLineArr[2];
				
				// state
				characterInfo[2] = fileLineArr[3];
				
				FormatClass character = new FormatClass(characterInfo[0], Integer.parseInt(characterInfo[1]), characterInfo[2]);
				
				println(character.toString());
				
				fileValue = br.readLine();
			}
			
		} catch (IOException e) {
			
			println("Something occured; see below:\n'" + e.getMessage() + "'");
			
//			e.printStackTrace();
//			
			println("------------------------------------------------");
			StringWriter error = new StringWriter();
			e.printStackTrace(new PrintWriter(error));
			println(error.toString());
			println("------------------------------------------------");
			
		}
	}
	
//	private static void createFile(String file) {
//		
//		// Write file
//		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
//			
////			bw.write("my first line\n");
//			bw.write("Omar:Acevedo:28:San Juan Puerto Rico:omaace@gmail.com\n");
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
