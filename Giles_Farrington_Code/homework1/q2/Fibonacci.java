package homework1.q2;

public class Fibonacci {

	public static void main(String[] args) {
	
		fib(25);

	}
	
	//Computes fibonacci through iteration
	public static void fib(int n) {
		int first = 0;
		int second = 1;
		int newNum = 0;
		
		System.out.println(first);
		System.out.println(second);
		
		for(int i = 0; i < n - 1; i++) {
			newNum = first + second;
			first = second;
			second = newNum;
			System.out.println(newNum);
		}
	}

}
