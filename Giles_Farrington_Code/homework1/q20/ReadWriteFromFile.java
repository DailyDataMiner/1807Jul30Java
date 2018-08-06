package homework1.q20;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadWriteFromFile {

	public static void main(String[] args) throws IOException {
		String[]textData = new String[4];
		displayCorrectly(openFile());

	}
	
	//Open and reads from file
	public static String[] openFile() throws IOException{
		FileReader fr = new FileReader("src/homework1/q20/Data.txt");
		BufferedReader textReader = new BufferedReader(fr);
		
		String[] textData = new String[4];
		
		for(int i = 0; i < 4; i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();
		return textData;
	}
	
	
	//Loops through String array containing each line of text from file for each index, during loop creates a new string array for each index
	//splitting at ':'. Then loops again through each string array and prints out the data correctly.
	public static void displayCorrectly(String[] data) {
		String temp = " ";	
		
		for(int i = 0; i < data.length; i++) {
			System.out.println("\n");
			String[] sub = data[i].split(":");
			temp = " ";
			for(int j = 0; j < sub.length; j++) {
				if(j == 0) {
					temp = sub[j];
				}
				else if(j == 1) {
					System.out.println("Name: " + temp + " " + sub[j]);
				}
				else if(j == 2) {
					System.out.println("Age: " + sub[j] + " years");
				}
				else {
					System.out.println("State: " + sub[j] + " State");
				}
			}
		}
	}

}
