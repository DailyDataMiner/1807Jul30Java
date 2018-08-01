package com.revature.wed;

public class fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fib(12));
	}
	
	
	public static int fib(int n) {
		int[] f = new int[n + 2];
		f[0] = 0;
		f[1] = 1;
		for(int i = 0; i <= n; i++) {
			if(i > 0) {
				f[i + 1] = f[i] + f[i-1];
			}
		}
		
		return f[n];
	}

}
