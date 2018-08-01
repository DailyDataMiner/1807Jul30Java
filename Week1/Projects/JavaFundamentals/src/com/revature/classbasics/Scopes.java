package com.revature.classbasics;

public class Scopes {

		/*Scopes
		 * The lifetime of a variable
		 * There are four different scopes in Java
		 * Class/Static = This is what we usually mean by global
		 * 		Static entities (vars, methods, nested classes_ are 
		 * 		accessible from outside the class without an instance 
		 * 		ie. Class.x or Class.method().
		 * 		Regarding static variables, these variables are shared
		 * 		throughout all instances of the class.
		 * 		Class c = new Class();
		 * 		Class c2 = new Class();
		 * 		c.x == c2.x //true
		 * 		
		 * 
		 * Object/Instance - the object's fields/state
		 * 		Entities in this scope can only be accessed by an instance 
		 * 		of the object they belong to.
		 * 		Ie. Class c - new Class();
		 * 			c.x or c.method();
		 * 			Not Class.method(); . this would be a static method
		 * Method = mostly parameters and any variables defined t the method
		 * 		Variables in this scope exist for the lifetime of a method
		 * 	Loop/Block = any variables defined within curly braces
		 * 
		 * WE CAN access static variables and methods from an instance of an object
		 * WE CANNOT access instance var and methods from a class alone
		 * 
		 * class A {
		 * 	static int count;
		 * 	int age;
		 * }
		 * 
		 * class B {
		 * 
		 * 	main {
		 * 	A.count // valid bc count is static
		 * A A = new A; //create instance of a aka instantiate A
		 * a.age; //valid bc age is instance var
		 * a.count; //valid bc a is an instance of class A
		 * A.age; //not valid
		 */
	
	int age;
	String name;
	static int count = 0;
	
	public Scopes() {
		//constructor..will discuss later
		count++;
	}
	

	public static void main(String[] args) {
		Integer num = new Integer(5);
		Integer x = new Integer(159109);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		
		Scopes s = new Scopes();
		s.age = 16;
		doThings();
	}
	//Static basically gives something a permanant trait like all humans have a certain common trait
	//Example static 
	// boss, workplace, hr -static variable
	// employee id, name, age -instance variable
	
	static void doThings() {
		//test();
	}
	
	void test() {
		doThings();
		
		
	}

}
