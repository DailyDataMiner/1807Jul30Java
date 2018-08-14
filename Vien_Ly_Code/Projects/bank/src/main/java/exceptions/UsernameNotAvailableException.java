package exceptions;

public class UsernameNotAvailableException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameNotAvailableException(String username) {
		super("Username " + username + " already exists.");
	}
}