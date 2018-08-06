package homework1.q18;

public class Test {

	//main method that creates new instance of SubClass. Creates test Strings to test methods and prints out results
	public static void main(String[] args) {
		SubClass test = new SubClass();
		String test1 = "this should return True since the T is capitalized";
		String test2 = "this should return flase since all lower case";
		String test3 = "234";
		
		System.out.println(test.checkUppercase(test1));
		System.out.println(test.checkUppercase(test2));
		System.out.println(test.convertUppercase(test2));
		System.out.println(test.convertInteger(test3));
	}
}
