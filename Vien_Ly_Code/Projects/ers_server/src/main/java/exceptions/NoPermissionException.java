package exceptions;

public class NoPermissionException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2468356205584707478L;

	public NoPermissionException(String message) {
        super(message);
    }
}
