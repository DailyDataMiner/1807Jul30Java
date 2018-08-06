package homework1.q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>(Arrays.asList("karan", "madam", "tom",
				"civic", "radar", "sexes", "jimmy", "kayak","john", "refer", "billy", "did"));
		ArrayList<String> palindrome = new ArrayList<>();
		
		//Gets each name from the array list, reverses it, then if it is equal to the original, adds it to new list. 
		//Which is then printed out 
		for(int i=0; i < names.size(); i++) {
			String currentName = names.get(i);
			StringBuilder current = new StringBuilder(currentName);
			current.reverse();
			String currentName2 = current.toString();
			if(currentName2.equals(currentName)) {
				palindrome.add(currentName);
			}
		}
		
		System.out.println(palindrome);

	}

}
