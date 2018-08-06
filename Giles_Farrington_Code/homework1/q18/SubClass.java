package homework1.q18;

	//Extends SuperClass containing abstract methods and implements them.
public class SubClass extends SuperClass{

	//converts str to char array, then loops through each element to check if upper case with .isUpperCase. 
	//Returns true if contains an uppercase character.
	@Override
	public boolean checkUppercase(String str) {
		char[] charArr = str.toCharArray();
		
		for(int i = 0; i < charArr.length; i++) {
			if(Character.isUpperCase(charArr[i])) {
				return true;
			}
		}
		return false;
	}

	//Simple convert all chars to uppercase method using .toUpperCase
	@Override
	public String convertUppercase(String str) {
		
		return str.toUpperCase();
	}

	//converts string to in, using .parseInt from the Integer class, adds 10 then returns result
	@Override
	public int convertInteger(String str) {

		int result = Integer.parseInt(str);
		return result + 10;
	}

}
