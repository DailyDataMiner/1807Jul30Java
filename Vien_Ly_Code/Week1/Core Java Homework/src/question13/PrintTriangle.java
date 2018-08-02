package question13;

public class PrintTriangle {

	public static void main(String[] args) {

		int i;
		int n = 4;
		String line = "0";
		for (i = 0; i < n; i++) {
			System.out.println(line);
			if (i % 2 == 0) {
				line += " 1";
			} else {
				line += " 0";
			}
		}
	}

}
