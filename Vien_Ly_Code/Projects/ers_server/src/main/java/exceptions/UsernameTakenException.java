package exceptions;

public class UsernameTakenException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9568878199149127L;

	public UsernameTakenException(String username) {
		super("Username " + username + " is taken");
	}
}
