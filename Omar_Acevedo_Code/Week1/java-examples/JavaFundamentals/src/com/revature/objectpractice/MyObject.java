package com.revature.objectpractice;

/**
 * Write a class MyObject that declares a property id (long). Override the equals method to compare two
objects and if the following occurs, returns true:
a. The second object is of type MyObject
b. The second object has an id property that is equal to this MyObject’s id property.
You will need to write an Application class to create two instances of MyObject that have the same
value for their id property. Write a conditional statement to test if the two objects are equivalent using
the .equals() method of your MyObject class. Print statements in the true condition and in the false
condition.
For this exercise, you’ll need to use the instanceof operator to check if a class is the same type as
another.
ex:
if (o instanceof SomeObject) { … }
 * @author omaracevedoacevedo
 *
 */

public class MyObject {
	long id;
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
