package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads text from a file
 * 
 * @author Arthur Panlilio
 *
 */
public class NotepadQuestion {

	public static void main(String[] args) {
		//The path of the file
		String file = "src/files/Data.txt";
	
		try(BufferedReader br = new BufferedReader(new FileReader(file));){
			String line = null;
			//Reads all the info and prints them accordingly 
			while((line=br.readLine()) != null) {
				String[] info = line.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
