package exceptions;

public class NoSuchUserException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchUserException(String username) {
		super("The username " + username + " is not associated with any of our existing customers");
	}
}
