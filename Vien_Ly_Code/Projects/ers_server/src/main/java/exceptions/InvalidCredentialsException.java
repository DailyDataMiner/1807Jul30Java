package exceptions;

public class InvalidCredentialsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8113893093020517577L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
