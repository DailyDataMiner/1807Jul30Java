package triangle_Q13;



public class triangle {

	public static void main(String[] args) {
		boolean change = true;
		for(int i=0; i < 4; i++) {
			for(int j=0; j<=i; j++) {
				if(change) {
				System.out.print(0 + " ");
				change =false;
				}
				else {
					System.out.print(1 + " ");
					change = true;
				}
			}
			System.out.print("\n");
		}
	}

}
