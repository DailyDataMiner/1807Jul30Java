public class FizzBuzz{
	public static void main(String[] args){

		String numb = args[0];
		
		int n = Integer.parseInt(numb);
		
		for(int k = 1; k <= n; k++){
			if(k % 15==0) {
				System.out.println("FizzBuzz");
			}
			else if(k%5==0){
				System.out.println("Buzz");
			}
			else if(k%3==0){
				System.out.println("Fizz");
			}
			else{
				System.out.println(k);
			}
		}
		
		
	}
}