package exceptions;

public class PasswordMismatchException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		super("The password you entered did not match");
	}
}
