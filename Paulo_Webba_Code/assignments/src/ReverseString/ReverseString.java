package ReverseString;

public class ReverseString {
    public static void reverse(String word) {
    	
	for(int i =0; i < word.length(); i++) {
	 word = word.substring(1, word.length()-i) + word.substring(0,1) + word.substring(word.length() - i, word.length());
		}
		System.out.println(word);
    }
	public static void main(String[] args) {
		
        reverse(".reniart ruo si siseneG");
	}

}
