package logica_Controladores;

public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }
		
	
	
}
