package utils;

import logica_Controladores.ControladorOferta;
import logica_Controladores.ControladorUsuario;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;
import logica_Manejadores.ManejadorOferta;
import logica_Manejadores.ManejadorPaquetesYTiposPubli;
import logica_Manejadores.ManejadorUsuario;


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
    
    // ---------------------------------------------

    public IManejadorOferta getInManejadorOferta() {
    	return ManejadorOferta.getInstance();
    }

	public IManejadorUsuario getInManejadorUsuario() {
		return ManejadorUsuario.getinstance();
	}

	public IManejadorPyT getInManejadorPyT() {
		return ManejadorPaquetesYTiposPubli.getInstance();
	}

}
