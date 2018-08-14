package exceptions;

public class NotEnoughFundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEnoughFundException(int id) {
		super("Account " + id + " does not have sufficient funds");
	}
}
