package com.testingArtifact;
import java.util.function.Predicate;

class MyClass {
	public void show() {
		System.out.println("Hello there");
	}
}

public class MyTestLambdas {

	public static void main(String[] args) {
		
		new MyClass().show();
		
//		Zero parameters
//		() -> System.out.println("No Params");
//		() -> System.out.println("hello");
//		
//		
////		One parameters
////		(param) -> System.out.println("One parameter: " + param);
//		(param) -> System.out.println("Hello " + param);
//		
////			w/o parenthesis
//// 		param -> param (Identity function example)
//		
//		
////		Multiple parameters
//		(param1, param2) -> param1 + param2;
//		
//		
////		Parameter types
//		(int i, String name) -> System.out.println("id: " + i + ", name: " + name);
//		
//		
////		Code block
//		(param1, param2) -> { return param1 + param2; }
//		
		
		
//		Comparator myComparator = (a1, a2) -> return a1 > a2;
//		boolean result = myComparator.compare(2, 5);
		
	}
	
}
