package com.Rev.assoc.Proj0.DAO;

public class Test {

	public static void main(String[] args) {
		Double[] makings = {40.0,22.2,22.22,64.0,820.2018};
		Double[] others = makings.clone();
		String[] notArgs = {"Come","on","baby", "catch", "me", "if", "you","can"};
		System.out.println(others.equals(makings));
		System.out.println(makings.hashCode());
		System.out.println(notArgs.toString());
		
	}

}
