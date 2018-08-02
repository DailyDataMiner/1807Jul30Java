package com.revature.datatypes;

public class UnderstandingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "hello";
		String b = new String("hello");
		String c = "";
		
		System.out.println(a == b);
		System.out.println(c == null);
		System.out.println(c == "");
		System.out.println(c.equals(new String("")));

		String conc = a+b;
		conc = conc + 100;
		System.out.println(conc);
		
		conc.concat("more things");
		
		System.out.println(conc);
		
		StringBuilder sbuild = new StringBuilder("Hello");
		sbuild.append(" world!");
		System.out.println(sbuild);
		sbuild.reverse();
		System.out.println(sbuild);
		
		StringBuffer sbuff = new StringBuffer(conc);
		
		// StringBuffer buffy = "Hi!"; This does not work!
		
		
		
	}

}
