package com.revature.q9;

import java.util.ArrayList;

public class NumberusPrime {
	public static void main(String[] args) {
		ArrayList<Integer> firsty = new ArrayList<Integer>();
		for(int i =1; i<=100;i++) {
			firsty.add(i);
			int o = i/2;
			for(int j=2;j<=o;j++) {
			//System.out.println(bgcd(i,j));
			if(i%j==0) {
				//System.out.println("Not Prime! ");
				break;
			}
			else {
				//System.out.println("Prime?");
				System.out.println(i);
			
			}
		}
 
	}

	}
}