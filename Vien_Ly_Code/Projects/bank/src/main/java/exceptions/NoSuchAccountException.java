package exceptions;

public class NoSuchAccountException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchAccountException(int id) {
		super("Not authorized to access account " + id);
	}
}
