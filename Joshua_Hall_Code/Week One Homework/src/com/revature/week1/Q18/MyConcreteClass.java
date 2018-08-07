package com.revature.week1.Q18;

public class MyConcreteClass extends MyAbstractClass {

	@Override
	public boolean hasUppercase(String str) {
		final int strlen = str.length();
		for(int i = 0; i < strlen; i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUppercase(String str) {
		final int asciiDistance = 'a' - 'A';
		final char[] data = str.toCharArray();
		final int datalen = data.length;
		for(int i = 0; i < datalen; i++) {
			if('a' <= data[i] && data[i] <= 'z') {
				data[i] -= asciiDistance;
			}
		}
		return String.valueOf(data);
	}

	@Override
	public void addTen(String str) {
		System.out.println(Integer.parseInt(str) + 10);

	}

}
