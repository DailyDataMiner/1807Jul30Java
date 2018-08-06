package homework1.q5;

public class SubString {

	public static void main(String[] args) {
		String str = "this will be a substring";
		subString(str, 7);

	}
	
	//Returns substring by converting String to charr array
	//And then re-adding sub String to new String
	public static void subString(String str, int idx) {
		char[] orig = str.toCharArray();
		char[] subStr = new char[idx-1];
		
		for(int i = 0; i < subStr.length; i++) {
			subStr[i] = orig[i];
		}
		String completed = new String(subStr);
		System.out.println(completed);
	}

}
