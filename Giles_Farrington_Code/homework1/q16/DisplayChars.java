package homework1.q16;



public class DisplayChars {

	//Loops through input from args. Each word is then converted to char array
	//which then loops through and counts each character.
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < args.length; i++) {
			char[] arr = args[i].toCharArray();
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] != ' ') {
					count ++;
				}
			}
		}
		System.out.println(count);
		

	}

}
