package Q8;

import java.util.ArrayList;

public class Palindromes {
public static void main(String[] args) {
	
	ArrayList<String> words = new ArrayList<String>();
	//Creating array
	words.add("madam");
	words.add("karan");
	words.add("tom");
	words.add("did");
	words.add("radar");
	words.add("sexes");
	words.add("jimmy");
	words.add("kayak");
	words.add("john");
	words.add("refer");
	words.add("billy");
	words.add("civic");
	
//if palindrome is true than it will add it to add to a second array
	ArrayList<String> onlyPalindromes = new ArrayList<String>();
	for(String s : words) {
		if(isPalindrome(s)) {
			onlyPalindromes.add(s);
		}
	}

	
	//	Prints words and palindromes	
	System.out.print("Words: ");
	System.out.println(words);
	System.out.print("Palindromes: ");
	System.out.println(onlyPalindromes);
}
//Checks to make sure it is a palindrome
static boolean isPalindrome(String text) {
	    int length = text.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) {
	        char forwardChar = text.charAt(forward++);
	        char backwardChar = text.charAt(backward--);
	        if (forwardChar != backwardChar)
	            return false;
	    }
	    return true;
}

static void palendromeArray (ArrayList<String> array) {
	ArrayList<String> onlyPalindromes = new ArrayList<String>();
	for(String i : array) {
	if (isPalindrome(i)) {
		onlyPalindromes.add(i);
		
	}
}
}
}
