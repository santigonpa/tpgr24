package utils;

import logica_Controladores.ControladorOferta;
import logica_Controladores.ControladorUsuario;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
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

    public ManejadorOferta getManejadorOferta() {
    	return ManejadorOferta.getInstance();
    }

	public ManejadorUsuario getManejadorUsuario() {
		return ManejadorUsuario.getinstance();
	}

	public ManejadorPaquetesYTiposPubli getManejadorPaquetesYTiposPubli() {
		// TODO Auto-generated method stub
		return null;
	}

}
