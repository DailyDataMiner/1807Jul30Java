package com.revature.q10;
import com.revature.helpers.HelperFunctions;

public class MinimumTwoNumbers extends HelperFunctions {

	public static void main(String[] args) {
		int n1 = 9;
		int n2 = 11;
		println("Minimum number between " + n1 + " and " + n2 + " is -> " + getMinNum(n1, n2));
		
		MinimumTwoNumbers m = new MinimumTwoNumbers();
		println(m.hashCode());
	}
	
	private static int getMinNum(int n1, int n2) {
		return (n1 < n2) ? n1 : n2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "-> ";
//		return super.toString();
	}

}
