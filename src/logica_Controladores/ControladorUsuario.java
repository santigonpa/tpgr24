package logica_Controladores;

public class ControladorUsuario implements IControladorUsuario {
	
	private static ControladorUsuario instancia;
	
	private ControladorUsuario() {}
	
	public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
		
	
	
}
