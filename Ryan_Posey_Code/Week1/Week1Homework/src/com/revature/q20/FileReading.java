package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
	// demonstration of simple file reading
	public static void main(String[] args){
		// create a new file reader in a try block, obtaining a file for reading
		try(BufferedReader br = new BufferedReader(new FileReader("src/files/Data.txt"))) {
			String line = null; // initial line
			while((line = br.readLine()) != null) { // while there is no line to read
				String[] info = line.split(":"); // split the read string and store it into an array of strings
				
				// display the information from the line to the console
				System.out.println("Name: " + info[0] + " " + info[1]); 
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
			}
		}
		catch(FileNotFoundException e) { // catch a FileNotFoundException
			e.printStackTrace();
		}
		catch(IOException e) { // Catch an IOException
			e.printStackTrace();
		}
	}
}
