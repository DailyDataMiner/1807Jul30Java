package question18;

public abstract class StringStuffs {
	abstract boolean hasUpperCase(String str);
	abstract String toUpperCase(String str);
	abstract int toInt(String str);


}

class Child extends StringStuffs {

	@Override
	boolean hasUpperCase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) return true;
		}
		return false;
	}

	@Override
	String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	int toInt(String str) {
		return Integer.valueOf(str) + 10;
	}

	
}

class Main {
	public static void main(String[] args) {
		Child test = new Child();
		System.out.println(test.hasUpperCase("hello world"));
		System.out.println(test.toUpperCase("hello world"));
		System.out.println(test.toInt("20"));
	}
}

