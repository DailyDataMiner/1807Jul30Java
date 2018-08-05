package question18;

public class subClass extends question18{

	@Override
	boolean checkCase(String str) {
		boolean upperFound =false;
		//String word = new String(str);
		char[] array = str.toCharArray();
		for (char c : array) {
		    if(c >= 65 && c <= 90) {
		    	System.out.println("There are uppercases.");
		    	upperFound = true;
		    	break;
		    }
		    
		}
		if(!upperFound)
		System.out.println("Uppercases not found.");
		return upperFound;
	}

	@Override
	void lowerCase(String str) {
		String word = new String(str);
		char [] array = word.toCharArray();
		int i =0;
		for(char c : array) {
			if(c >= 97 && c <= 122) {
				c = Character.toUpperCase(word.charAt(i));
				System.out.print(c);
			} else System.out.print(c);
			i++;
			
			
		}
	}

	@Override
     void stringtoInt(String str) {
		int number = Integer.parseInt(str);
	    System.out.println("\n" + (number + 10));
		
	}

}
