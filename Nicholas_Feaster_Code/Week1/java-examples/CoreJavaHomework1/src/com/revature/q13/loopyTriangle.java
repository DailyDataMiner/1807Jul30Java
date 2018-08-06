package com.revature.q13;

public class loopyTriangle {

	public static void main(String[] args) {
		int alt = 0;
		for (int i=0;i<4;i++) {
			int counter = i+1;
			for (int j=0;j<counter;j++) {
				System.out.print(alt);
				if(alt == 0) {
					alt++;
				}
				else {
					alt--;
				}
				
			}
			System.out.println();
		}
	}

}
