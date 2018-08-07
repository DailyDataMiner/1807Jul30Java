package com.revature.week1.Q20;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	private static final String WD = System.getProperty("user.dir");

	public static void main(String[] args) {
		try(FileReader fr = new FileReader(WD + "/src/com/revature/week1/Q20/Data.txt")) {
			String fileContents = "";
			char buf;
			while((buf = (char) fr.read()) != (char) -1) {
				fileContents += buf;
			}
			String[] people = fileContents.split("\n");
			for(String str : people) {
				Person person = new Person(str);
				person.display();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
