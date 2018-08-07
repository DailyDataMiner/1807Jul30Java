package com.revature.week1.Q8;

import java.util.ArrayList;
import java.util.List;
import com.revature.week1.Q3.ReverseString;

public class Palindromes {

	private static ArrayList<String> createList() {
		ArrayList<String> list = new ArrayList<String>();
		String[] strArr = {"karan", "madam", "tom", "civic", 
				"radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		for(String str : strArr) {
			list.add(str);
		}
		return list;
	}
	
	private static <T> void printList(List<T> list) {
		for(T t : list) {
			System.out.print(t + " ");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = createList();
		ArrayList<String> palindrone = new ArrayList<String>();
		for(String str : list) {
			if(str.equals(ReverseString.reverse(str))) {
				palindrone.add(str);
			}
		}
		printList(palindrone);
	}

}
