package com.revature.q11part2;

/**
 * A class in another package
 * 
 * @author Arthur Panlilio
 *
 */
public class AnotherPackageQuestionClass {
	//These fields are protected so the main in another package must use the getters provided
	protected float x1;
	
	protected float x2;
	
	public AnotherPackageQuestionClass(int theX1, int theX2) {
		x1 = theX1;
		x2 = theX2;
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

}
