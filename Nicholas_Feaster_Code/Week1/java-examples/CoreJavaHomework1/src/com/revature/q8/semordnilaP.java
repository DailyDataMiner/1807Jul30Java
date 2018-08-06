package com.revature.q8;

import java.util.ArrayList;

public class semordnilaP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(args[0]);
		
		ArrayList<String> box = new ArrayList<String>();
		for(int step = 0;step<args.length;step++) {
			box.add(args[step]);
		}
		ArrayList<String> boxy = new ArrayList<String>();
		for(int isPal =0; isPal<box.size();isPal++) {
			StringBuilder rever = new StringBuilder(box.get(isPal));
			rever = rever.reverse();
			//System.out.println(rever);
			if( box.get(isPal).equals(rever.toString())) {
				boxy.add(box.get(isPal));
			}
		}
		for(String peanut:box) {
			System.out.print(peanut + " div ");
		}
		System.out.println(boxy.size());
		for(String wrap:boxy) {
			System.out.print(wrap +" ");
		}
	}

}
