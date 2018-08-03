// Logan Smith, 8/2/2018
// Class to read in a file, then print out it contents in a specific way

package IOReaderPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CelebrityIOReader {

	public static void main(String[] args) {
		
		CelebrityIOReader celeb = new CelebrityIOReader();
		celeb.displayData();
	}
	
	public void displayData() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/Files/CelebrityInfo.txt"))){ // Creates a file reader for the celebrity file
			String line = null;
			while((line=br.readLine()) != null) { // reads through each line
				String[] celebInfo = line.split(":"); // splits the celeb info on :
				System.out.println("Name: " + celebInfo[0] + " " + celebInfo[1]);
				System.out.println("Age: " + celebInfo[2] + " years");
				System.out.println("State: " + celebInfo[3] + " State");
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
