package com.revature.q18;

public class Driver {

	public static void main(String[] args) {
		CaseSerf six = new CaseSerf();
		CaseSerf four = new CaseSerf();
		CaseSerf doubFour = new CaseSerf();
		System.out.println(six.anyUppers("CalciumThree"));
		System.out.println(six.anyUppers("no"));
		System.out.println(six.anyUppers("ALL"));
		System.out.println(four.bigIfSmall("help"));
		System.out.println(four.bigIfSmall("I NeEd"));
		System.out.println(four.bigIfSmall("NOT JUST"));
		doubFour.plusTen("85");
		doubFour.plusTen("2018");
	}

}
