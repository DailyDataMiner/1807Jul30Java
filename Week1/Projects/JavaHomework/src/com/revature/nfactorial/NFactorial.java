package com.revature.nfactorial;

import java.math.BigInteger;

//uses BigInteger to calculate larger factorials.
public class NFactorial {

	static BigInteger computeFactorial (int n) {
		
		BigInteger result = BigInteger.ONE;
	
		for (int i=n; i>0; i--) {
			result = result.multiply(BigInteger.valueOf(i));
			}
		return result;		
		} 
		
	


	
	public static void main(String[] args) {
		System.out.println(computeFactorial(50));
		System.out.println(computeFactorial(1));
		System.out.println(computeFactorial(0));
		System.out.println(computeFactorial(15));
		System.out.println(computeFactorial(100));


	}

}
