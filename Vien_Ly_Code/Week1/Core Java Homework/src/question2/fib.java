package question2;

public class fib {

	public static void main(String[] args) {
		int n = 25;
		for (int i = 0; i < n; i++) {
			System.out.print(fib(i) + " ");
		}

	}
	
	public static int fib(int n) {
		if (n <= 1) return n;
		return fib(n - 1) + fib(n - 2);
		
	}

}
