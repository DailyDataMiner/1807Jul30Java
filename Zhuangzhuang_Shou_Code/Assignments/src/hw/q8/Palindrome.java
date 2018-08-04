package hw.q8;

import java.util.ArrayList;

public class Palindrome 
{
	public static void main(String[] args) 
	{
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("karan");
		aList.add("madam");
		aList.add("tom");
		aList.add("civic");
		aList.add("radar");
		aList.add("sexes");
		aList.add("jimmy");
		aList.add("kayak");
		aList.add("john");
		aList.add("refer");
		aList.add("billy");
		aList.add("did");
		
		ArrayList<String> palindromeList = getPalindromes(aList);
		System.out.println(palindromeList.toString());
	}
	
	public static ArrayList<String> getPalindromes(ArrayList<String> listIn)
	{
		ArrayList<String> aList = new ArrayList<String>();
		for (String s: listIn)
		{
			boolean match = true;
			for (int i = 0; i < s.length()/2; i++)
			{
				if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				{
					match = false;
					break;
				}
			}
			if (match)
			{
				aList.add(s);
			}
		}
		return aList;
	}

}
