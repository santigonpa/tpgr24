package logica_Controladores;

import logica_Controladores.ControladorOferta;
import logica_Controladores.ControladorUsuario;


	public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorOferta getInOfer() {
        return ControladorOferta.getInstance();
    }
    
    public IControladorUsuario getInUser() {
        return ControladorUsuario.getInstance();
    }

}
