package excepciones;

public class noExistePublicacionException extends Exception{
	private static final long serialVersionUID = 1L;

	public noExistePublicacionException(String string) {
		super(string);
	}
}
