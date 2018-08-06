package com.revature.txtio;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;

public class ScannerExample {

	// static void format ()

	public static void main(String[] args) {

		/*
		 * try (BufferedWriter bw = new BufferedWriter(new
		 * FileWriter("src/Files/Data.txt", true));) {
		 * bw.write("Mickey:Mouse:35:Arizona \n");
		 * bw.write("Hulk:Hogan:50:Virginia \n");
		 * bw.write("Roger:Rabbit:22:California \n");
		 * bw.write("Wonder:Woman:18:Montana \n");
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		String line = null;
		try { //throw 
			FileReader fr = new FileReader("src/Files/Data.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String[] line2 = line.split(":");
				System.out.println("Name: " + line2[0] + " " + line2[1]);
				System.out.println("Age: "+ line2[2] + " years");
				System.out.println("State: " + line2[3] + " State\n");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("We can't find what you're looking for!");
			// ex.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading file!");
		} 
	}
}
