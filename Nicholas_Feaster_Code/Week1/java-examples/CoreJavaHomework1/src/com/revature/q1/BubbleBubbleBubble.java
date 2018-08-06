package com.revature.q1;

import java.util.ArrayList;

public class BubbleBubbleBubble {

	public static void main(String[] args) {
		//System.out.println(args.length);
		//For now the program will assume the integer array will be given as arguments when the program is run
		//The assumption is made that all given arguments are integers that should be sorted
		 ArrayList<Integer> sortMe = new ArrayList<Integer>();
		
		//Create new array to store integer values
		//int[] sortMe = new int[args.length];
		//Loop through to turn string into integers
		for(int looper=0;looper<args.length;looper++) {
			//should probably add exception for non Integer inputs...
			sortMe.add(Integer.parseInt(args[looper]));
			//System.out.println(sortMe.get(looper));
		}
		//int[] altInput = sortMe.toArray();
		//System.out.println("she's so grown woman and i'm so childish");
		
		Integer greatest = new Integer(sortMe.get(0)); 
		for(int outer = 0;outer<sortMe.size();outer++) {
		for ( int inner=0;inner<sortMe.size()-1;inner++) {
			int next = inner + 1;
			if(sortMe.get(next)<sortMe.get(inner)) {
				Integer goBet = sortMe.get(next);
				sortMe.set(next, sortMe.get(inner));
				sortMe.set(inner, goBet);
				//System.out.println("Last dance for Mary Jane: " + sortMe.get(sortMe.size()-1));
			}
			
		}
		}
		/*for(int l2=0;l2<sortMe.size()-1;l2++) {
			Integer helper = new Integer(-1);
			for(int inner=0;inner<sortMe.size();inner++) {
			if(sortMe.get(l2)>sortMe.get(inner)) {
				helper = sortMe.get(inner);
				sortMe.set(inner,sortMe.get(l2));
				System.out.println(l2);
				sortMe.set(inner, helper);
				}
			}
		}*/
		
		//System.out.println();
		
		for(Integer q : sortMe) {
			System.out.print(q);
		}
		System.out.println();
		/*for(int i=0;i<sortMe.size();i++) {
			System.out.print(sortMe.get(i));
		}*/
		//success of loop confirms that args splits on space
		//possible further testing possible
		/*//new array for the output
		int[] bubbled = new int[sortMe.length];
		int workingNum = sortMe.length;
		//next for loop to implement a sort
		for(int outer = 0; outer<sortMe.length;outer++) {
			int greatest = sortMe[outer];
			for(int inner = 0; inner<sortMe.length;inner++) {
				if(sortMe[inner]>=greatest) {
					greatest = sortMe[inner];
				}
			}
			workingNum--;
			bubbled[workingNum]=greatest;
			
		}
		System.out.print("I. Am. Sorted. ");

		for(int lastly=0;lastly<bubbled.length;lastly++) {
			System.out.print(bubbled[lastly]+" ");
		}
	


*/
		//Alright let's try this AGAIN
		
	}	
}
