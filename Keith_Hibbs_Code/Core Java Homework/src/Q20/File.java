package Q20;
	import java.io.*;
	import java.util.Scanner;
public class File {


		public static void main(String[] args)throws Exception {
		  
			String file = "C:\\Users\\keith\\my_git_repos\\1807Jul30Java\\Keith_Hibbs_Code\\Core Java Homework\\hmwk1.txt";
			String line = "";
			String splitBy = ":";
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				// Continues if there is stuff on the next line
				while ((line = br.readLine()) != null) {
					// Puts the data into an array, from the various splits
					String[] data = line.split(splitBy);
					 
					System.out.println("Name: " + data[0] + " " + data[1]);
					System.out.println("Age: " + data[2]);
					System.out.println("State: " + data[3]);
					System.out.println("");
				}
			}
		}
	}

