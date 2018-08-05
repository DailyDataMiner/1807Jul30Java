package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {
	
	public static void main(String[] args) {
		readCharacters();
	}

	//creates buffered and file readers
	static void readCharacters(){
		try(BufferedReader cr = new BufferedReader(new FileReader("src/com/revature/q20/Data.txt"))){
			String line = null;
			//splits each line in to categories by position in array
			while((line = cr.readLine()) != null) {
				String[] charInfo = line.split(":");
				System.out.println("Name: " + charInfo[0] + " " + charInfo[1]);
				System.out.println("Age: " + charInfo[2] + " years");
				System.out.println("State: " + charInfo[3] + " State" +"\n");	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
