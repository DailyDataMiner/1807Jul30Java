package Palindromes;

import java.util.ArrayList;

public class Palindromes {
	
	public static boolean isPalindrome(String word) {
		boolean palindromeIndeed = false;
		
		String str = new String(word);
		char[] array = str.toCharArray();
		int number = (array.length) -1; 
		 for(char c : array ){
				if (c == word.charAt(number)){
					 number--;
					if(number == 0){
						// System.out.println("The word "+ str + " is a Palindrome.");
						 //System.out.println(" ");
						 return !palindromeIndeed;
					}
				}
				else {
							//System.out.print("The word " + str + " is not a Palindrome.");
							//System.out.println(" ");
							return palindromeIndeed;
				     }
			}
		return palindromeIndeed;
	}
	
	public static void main(String[] args) {
		ArrayList <String> words = new ArrayList<String>();
		ArrayList <String> palindromes = new ArrayList<String>();
		String karan= "karan";
		String madam = "madam";
		String tom = "tom";
		String civic = "civic";

		words.add(karan);
		words.add(madam);
		words.add(tom);
		words.add(civic);
		System.out.println("All the given words:");
		for(int i=0; i < words.size() ; i++) {
			if(i < 3) System.out.print(words.get(i) + ", ");
			if(i == 3) System.out.print(words.get(i) + ".\n");
			
		}
		System.out.print("\n");
		System.out.println("All the palindromes from the given words:");
		
		for(int i=0; i < words.size() ; i++) {
		    if(isPalindrome(words.get(i))) {
		    	palindromes.add(words.get(i));
		    	if(i < 3) System.out.print(words.get(i) + ", ");
		    	if(i == 3) System.out.print(words.get(i) + ".\n");
		    }
		  
		}
		
		
	}

}
