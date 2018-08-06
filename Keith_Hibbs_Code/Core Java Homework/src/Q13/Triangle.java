package Q13;

public class Triangle {
public static void main(String[] args) {
		
		int n = 4;

        for(int i=0; i<n; i++) {
 
                if (i == 0) {
                	System.out.print("0");
                }
                else if (i == 1) {
                	System.out.print("1 " + "0");
                }
                else if (i == 2) {
                	System.out.print("1 " + "0 " + "1");
                }
                else if (i == 3) {
                	System.out.print("0 " + "1 " + "0 " + "1");
                }
            System.out.println();
        }
	}
}
//