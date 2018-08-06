package homework1.q4;

public class NFactorial {

	public static void main(String[] args) {

		nFactorial(9);
	}
	
	//Computes N factorial
	public static void nFactorial(int n) {
		int orig = n;
		int prev = n - 1;
		for(int i = n; i > 1; i--) {
			n = n * prev;
			prev--;
			System.out.println(n);
		}
		System.out.println("N factorial for " + orig + " is: " + n);
	}

}
