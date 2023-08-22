package logica_excepciones;

public class EmailYaExisteException extends Exception {
	public EmailYaExisteException(String s) {
		super(s);
	}
}
