package exceptions;

public class ShortInputException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShortInputException(String input) {
		super("Your input \"" + input + "\" does not satisfy the input requirement");
	}
}
