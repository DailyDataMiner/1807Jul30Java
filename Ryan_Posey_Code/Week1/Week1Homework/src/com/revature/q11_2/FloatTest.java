package com.revature.q11_2;
import com.revature.q11_1.*; // import the package containing the float POJO

public class FloatTest {

	public static void main(String[] args) {
		// initialize an object of float class
		FloatClass fc = new FloatClass(24.3f, 28.6f);
		
		// print the float variables in the FloatClass instance
		System.out.println("This FloatClass object's float variables are: " + fc.getF1() + " and " + fc.getF2());
		

	}

}
