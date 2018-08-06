package com.group.ex;

import java.util.ArrayList;

public class ListOMania {

	public static void main(String[] args) {
		ArrayList<String> wordExample = new ArrayList<String>(15);
		ArrayList<String> wordExample2 = new ArrayList<String>();
		ArrayList<Integer> integerExample = new ArrayList<Integer>(24);
		wordExample2.add("I");
		wordExample2.add("am");
		wordExample2.add("Groot");
		System.out.println("Length of second array List: "+ wordExample2.size());
		System.out.println("Is first array list empty? " + wordExample.isEmpty());
		for(Integer i = 0; i<42;i++) {
			integerExample.add(i);
		}
		
		System.out.print("Integer Array: ");
		for (int c = 0; c<integerExample.size();c++ ) {
			System.out.print(integerExample.get(c)+ " ");
			}
		System.out.println();
		String[] runOn={"John", "while", "James", "had",  "had", "had", "had", "had", "had", "had", "had", "had", "had", "had", "a", "better", "effect", "on", "their", "teacher"};
	
		for(int q=0; q<runOn.length;q++) {
			wordExample.add(runOn[q]);
		}
		System.out.print("First Array List: ");
		for (int r = 0; r<wordExample.size();r++ ) {
		System.out.print(wordExample.get(r)+ " ");
		}
		System.out.println();
		System.out.println("Length of first array List: "+ wordExample.size());
		
	}
}
