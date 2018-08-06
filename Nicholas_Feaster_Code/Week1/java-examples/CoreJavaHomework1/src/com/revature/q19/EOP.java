package com.revature.q19;

import java.util.ArrayList;

public class EOP {

	public static void main(String[] args) {
		ArrayList<Integer> tech = new ArrayList<Integer>();
		int evan = 0;
		int ood = 0;
		for(int i = 1; i<11;i++) {
			tech.add(i);
		}
		System.out.println("The Array List");
		
		for(int o : tech) {
			System.out.println(o);
			if(o%2==0) {
				evan+=o;
			}
			else {
				ood+=o;
			}
					}
		
		System.out.println("The even sum: " + evan);
		System.out.println("The odd sum: " + ood);
		System.out.println("The non-primes: ");
		for(int q =0;q<tech.size();q++) {
			int n = tech.get(q)+1;
			//System.out.println(n);
			for(int w = 2;w<n;w++) {
				//System.out.println(q + " " + w);
				if(tech.get(q)%w==0) {
					System.out.println(tech.get(q));
					break;
				}
				else {
					//System.out.print("S "+ q);
					tech.remove(q);
					//continue;
				}
			}
		}
	}

}
