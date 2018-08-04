// Logan Smith, 8/2/2018
// Class to seperate normal strings from palindromes

package question8;

import java.util.ArrayList;

public class PalindromeStorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PalindromeStorer ps = new PalindromeStorer(); // Instance to reference function
		ArrayList<String> generalList = new ArrayList<String>(); // General list of strings
		ArrayList<String> palindromeList = new ArrayList<String>(); // To be Palindrome list
		
		generalList.add("karan");
		generalList.add("madam");
		generalList.add("tom");
		generalList.add("civic");
		generalList.add("radar");
		generalList.add("sexes");
		generalList.add("jimmy");
		generalList.add("kayak");
		generalList.add("john");
		generalList.add("refer");
		generalList.add("billy");
		generalList.add("did");
		
		palindromeList = ps.palindromeMove(generalList, palindromeList); // Call to palindromeMove
		
		//output
		
		for (String a : palindromeList) {
			System.out.println(a);
		}
		
		
	}
	
	
	// Function to move all palindromes to a palindrome list. Takes in a general list and the to be palindrome list, and returns the palindrome
	// list when done. 
	public ArrayList<String> palindromeMove(ArrayList<String> generalList, ArrayList<String> palindromeList) {
		for (String a : generalList) { // Loops through general list
			boolean isPalindrome = true; // Sets boolean to be initially true
			for (int i = 0; i < (a.length()/2); i++) { // Loops through half of the string
				if (a.charAt(i) != a.charAt((a.length()-1)-i)) { // checks to see if a char at the start is not equal to one at the end, going down to the middle
					isPalindrome = false; // If they are not the same, it is disqualified as a palindrome
				}
			}
			if (isPalindrome == true) { // if it was not disqualified...
				palindromeList.add(a); // add it to the list
			}
		}
		return palindromeList;
	}

}
