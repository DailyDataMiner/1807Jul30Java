package com.revature.q3;

import java.util.ArrayList;

public class ReverseReverse {

	public static void main(String[] args) {
		String smoothOperand = "turnturnturn"; 
		//Character testytesty = new Character('q');
		ArrayList<Character> formal = new ArrayList<Character>();
		System.out.println("Forward: " + smoothOperand);
		System.out.print("Backward: ");
		for(int finalCountdown = smoothOperand.length()-1;finalCountdown>-1;finalCountdown--) {
			System.out.print(smoothOperand.charAt(finalCountdown));
			formal.add(smoothOperand.charAt(finalCountdown));
		/*Character[] middleman = formal.toArray( );
		String esrever = formal.toString();
		System.out.println(esrever);*/
		}
	}
}