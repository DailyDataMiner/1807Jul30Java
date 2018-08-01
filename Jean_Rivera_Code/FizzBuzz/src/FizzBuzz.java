
public class FizzBuzz {
	
	
	public static void main(String[] args) {
		
		
		
		
		//String num = args[0];
		
		
		//int n = Integer.parseInt(num);
		
		int n = 100;

		
		
		String word1 = "Fizz";
		String word2 = "Buzz";
		String wordTotal = "";
		
		for (int i = 0; i <= n; i++) {
			
			wordTotal="";
			
			
			
			if(i % 3 == 0) {
				wordTotal = wordTotal + word1;
			}
			
			if(i % 5 == 0) {
				wordTotal = wordTotal + word2;
			}
			
			System.out.println(i+": "+wordTotal);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
