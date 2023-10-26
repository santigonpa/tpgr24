package utils;

import logica_controladores.ControladorOferta;
import logica_controladores.ControladorUsuario;
import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;
import logica_manejadores.ManejadorOferta;
import logica_manejadores.ManejadorPaquetesYTiposPubli;
import logica_manejadores.ManejadorUsuario;


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
        return (IControladorOferta) ControladorOferta.getInstance();
    }
    
    public IControladorUsuario getInUser() {
        return (IControladorUsuario) ControladorUsuario.getInstance();
    }
    
    // ---------------------------------------------

    public IManejadorOferta getInManejadorOferta() {
    	return (IManejadorOferta) ManejadorOferta.getInstance();
    }

	public IManejadorUsuario getInManejadorUsuario() {
		return (IManejadorUsuario) ManejadorUsuario.getinstance();
	}

	public IManejadorPyT getInManejadorPyT() {
		return (IManejadorPyT) ManejadorPaquetesYTiposPubli.getInstance();
	}

}
