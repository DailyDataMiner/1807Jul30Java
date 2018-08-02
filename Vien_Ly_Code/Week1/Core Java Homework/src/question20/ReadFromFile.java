package question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

	public static void main(String[] args) {
		List<Character> allCharacters = readCharacters();
		for (Character c : allCharacters) {
			System.out.println(c);
			System.out.println();
		}
	}

	static List<Character> readCharacters() {
		List<Character> s = new ArrayList<Character>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/question20/characters.txt"));) {
			String line;
			while((line = br.readLine()) != null) {
				String[] characterInfo = line.split(":");
				Character temp = new Character(characterInfo[0], characterInfo[1], Integer.parseInt(characterInfo[2]), characterInfo[3]);
				s.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
}

