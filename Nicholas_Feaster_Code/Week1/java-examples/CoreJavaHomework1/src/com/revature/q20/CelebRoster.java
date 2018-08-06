package com.revature.q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class CelebRoster {

	public static void main(String[] args) {
		ArrayList<Entry> celebs = new ArrayList<Entry>();
		try(BufferedReader br = new BufferedReader(
				new FileReader("src/Data.txt"))) {
			String line = null;
			while((line=br.readLine())!=null) {
				String[] dater = line.split(":");
				Entry temp = new Entry();
				temp.setFirstname(dater[0]);
				temp.setLastname(dater[1]);
				temp.setAge(Integer.parseInt(dater[2]));
				temp.setState(dater[3]);
				celebs.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Entry who : celebs) {
			System.out.println("Name: " + who.getFirstname() + " "+ who.getLastname());
			System.out.println("Age: " +  who.getAge() + " years");
			System.out.println("State: " + who.getState() + " State");
		}
	}

}
