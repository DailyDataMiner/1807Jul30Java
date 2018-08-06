package Q5;

public class aSubstringMethod {

	public void aSubstringMethod(String str, int idx) {
		
		for(int i = 0; i < idx; i++) {
			System.out.print(str.charAt(i));

		}
		
	}
	
	public static void main(String[] args) {
		
		aSubstringMethod a = new aSubstringMethod();
		a.aSubstringMethod("testing the substring method", 10);
		
	}

}
