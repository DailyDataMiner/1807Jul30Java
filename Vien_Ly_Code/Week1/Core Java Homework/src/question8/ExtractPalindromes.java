package question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractPalindromes {

	public static void main(String[] args) {
		List<String> allStrings = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		List<String> palindromes = new ArrayList<String>();
		
		for(String str : allStrings) {
			if (isPalindrome(str)) {
				palindromes.add(str);
			}
		}
		
		System.out.println(allStrings.toString());
		System.out.println(palindromes.toString());
	}
	
	public static boolean isPalindrome(String str) {
		char[] ch = str.toCharArray();
		
		for(int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[ch.length - i - 1]) return false;
		}
		return true;
	}

}
