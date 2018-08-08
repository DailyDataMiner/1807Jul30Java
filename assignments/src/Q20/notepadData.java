package Q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class notepadData {

	public static void main(String[] args) {
		readFile("Data.txt");
	}

	public static void readFile(String fileName) {
		try {
			File f = new File(fileName);
			BufferedReader buff = new BufferedReader(new FileReader(f));
			String line;
			while((line = buff.readLine()) != null){
				String[] data = line.split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2] + " years");
				System.out.println("State: " + data[3] + " State");
				System.out.println();
			}
			buff.close();
		}catch (FileNotFoundException e){
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Io Exception");
		}
	}
}	