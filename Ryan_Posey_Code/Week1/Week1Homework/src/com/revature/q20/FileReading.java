package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
	// DONE!!!
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/files/Data.txt"))) {
			String line = null;
			while((line = br.readLine()) != null) {
				String[] info = line.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
