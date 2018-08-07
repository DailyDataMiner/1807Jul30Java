package com.revature.week1.Q15;

public class MyInteger implements Calculable {
	
	private int i;
	
	MyInteger(int i){
		this.i = i;
	}
	
	public int intValue() {
		return i;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}

	@Override
	public MyInteger addition(Calculable calc) {
		return new MyInteger(this.i + ((MyInteger) calc).intValue());
	}

	@Override
	public MyInteger subtraction(Calculable calc) {
		return new MyInteger(this.i - ((MyInteger) calc).intValue());
	}

	@Override
	public MyInteger multiplication(Calculable calc) {
		return new MyInteger(this.i * ((MyInteger) calc).intValue());
	}

	@Override
	public MyInteger division(Calculable calc) {
		return new MyInteger(this.i / ((MyInteger) calc).intValue());
	}

}
