package excepciones;

public class EmailYaExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailYaExisteException(String s) {
		super(s);
	}
}
