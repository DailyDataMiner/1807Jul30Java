package com.revature.filterpalindromes;



import java.util.ArrayList;


//separate palindromes from other strings in an ArrayList ie pull palindromes and put into another ArrayList
	public class FilterPalindromes {

		static void filterPalindromes(ArrayList<String> myList) {
			
			
			ArrayList<String> palindromeList = new ArrayList<String>();
			int i = 0;
			
			
				boolean isPalindrome = true;
			while (myList.size() > i){
	
				String str = myList.get(i);
				for (int j=0; j<str.length()/2; j++) { //start from left side of string and go halfway
					
					if (str.charAt(j) != str.charAt(str.length()-1-j)) {
							isPalindrome = false;
							i++;
							break;
						}
						else {
							isPalindrome = true;

						}
				}
						if (isPalindrome == true) {
							myList.remove(i);
							palindromeList.add(str);
					
					}
					myList.trimToSize();
					if (myList.size() == i) {
						System.out.println("Original ArrayList = " + myList);
						System.out.println("Palindrome ArrayList = " + palindromeList);
						return;
					}
				}
		}


		public static void main(String[] args) {
		
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add("karan");
			arrayList.add("madam");
			arrayList.add("tom");
			arrayList.add("civic");
			arrayList.add("radar");
			arrayList.add("sexes");
			arrayList.add("jimmy");
			arrayList.add("kayak");
			arrayList.add("john");
			arrayList.add("refer");
			arrayList.add("billy");
			arrayList.add("did");
			
			//System.out.println(arrayList);
			filterPalindromes(arrayList);
		   
	}
	
}

		
		
		
		
		
