package question3;

public class StringReverse {
	
	public static void main(String[] args) {
		System.out.println(rev("hello world"));
	}
	
	public static String rev(String str) {
		char[] ch = str.toCharArray();
		int s = 0;
		int e = ch.length - 1;
		
		while (e > s) {
			ch[s] ^= ch[e];
			ch[e] ^= ch[s];
			ch[s] ^= ch[e];
			
			s++;
			e--;
		}
		
		return new String(ch);
	}
}
