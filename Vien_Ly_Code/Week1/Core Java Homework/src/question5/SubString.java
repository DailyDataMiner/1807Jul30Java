package question5;

public class SubString {

	public static void main(String[] args) {
		System.out.println(substring("hello world", 5));
	}
	
	public static String substring(String str, int idx) {
		char[] ch = str.toCharArray();
		char[] result = new char[idx];
		for (int i = 0; i < idx; i++) {
			result[i] = ch[i];
		}
		return new String(result);
	}

}
