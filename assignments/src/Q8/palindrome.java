package Q8;

import java.util.ArrayList;

public class palindrome {

	public static void main(String[] args) {
		
		ArrayList<String> myListOfWords = new ArrayList<String>();
		myListOfWords.add("karan");
		myListOfWords.add("madam");
		myListOfWords.add("tom");
		myListOfWords.add("civic");
		myListOfWords.add("radar");
		myListOfWords.add("sexes");
		myListOfWords.add("jimmy");
		myListOfWords.add("kayak");
		myListOfWords.add("john");
		myListOfWords.add("refer");
		myListOfWords.add("billy");
		myListOfWords.add("did");
		
		palindromeArray(myListOfWords);
		
	}

	public static void printPalindromes(ArrayList<String> mlop) {
		
		for(String s : mlop) {
			System.out.println(s);
		}
	}
	
	public static void palindromeArray(ArrayList<String> mlow) {
		ArrayList<String> myListOfPalindromes = new ArrayList<String>();
		
		for(String s : mlow) {
			if(isPalindrome(s)) {
				myListOfPalindromes.add(s);
			}
		}
		
		printPalindromes(myListOfPalindromes);
		
	}
	
	public static Boolean isPalindrome(String w) {
		String temp = "";
		
		for(int i = w.length() - 1; i > -1; i--) {
			temp = temp + w.charAt(i);
		}
		
		if (w.equals(temp)) {
			return true;
		}
			
		return false;
	}
	
}
