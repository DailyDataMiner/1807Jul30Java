package question13;

public class PrintTriangle {

	public static void main(String[] args) {

		int counter = 0;
		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (counter % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
				++counter;
			}
			System.out.println();
		}
	}

}
