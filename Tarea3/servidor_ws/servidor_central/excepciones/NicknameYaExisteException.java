package excepciones;

public class NicknameYaExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NicknameYaExisteException(String string) {
		super(string);
	}
}
