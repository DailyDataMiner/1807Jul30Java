package com.revature.abstractclass;

public class ImplementAbstractClass extends AbstractClassDemonstration {

	public boolean checkUppercase(String str) {

		return !str.equals(str.toLowerCase());
	}

	@Override
	String convertLowertoUpper(String str) {

		return str.toUpperCase();
	}

	@Override
	int addStringtoInt(String str) {

		return Integer.valueOf(str) + 10;
	}

	public static void main(String[] args) {

		AbstractClassDemonstration a = new ImplementAbstractClass();
		System.out.println(a.checkUppercase("munchkins"));
		System.out.println(a.checkUppercase("oVerLord"));

		System.out.println(a.convertLowertoUpper("i had a fever last week"));

		System.out.println(a.addStringtoInt("100"));

	}
}
