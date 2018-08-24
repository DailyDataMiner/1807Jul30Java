package exceptions;

public class NoSuchUserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7076508806928000177L;

	public NoSuchUserException(String username) {
		super("Username " + username + " does not exist in our database");
	}
}
