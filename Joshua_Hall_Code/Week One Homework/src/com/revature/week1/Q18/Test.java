package com.revature.week1.Q18;

public class Test {

	public static void main(String[] args) {
		MyConcreteClass myClass = new MyConcreteClass();
		final String str1 = "The quick brown fox jumps over the lazy dog.";
		final String str2 = "the quick brown fox jumps over the lazy dog.";
		final String str3 = "the quick brown fox jumPs over the lazy dog.";
		
		System.out.println(myClass.hasUppercase(str1));
		System.out.println(myClass.hasUppercase(str2));
		System.out.println(myClass.hasUppercase(str3));
		
		System.out.println(myClass.toUppercase(str1));
		myClass.addTen("2718");
	}

}
