package logica_Controladores;

import java.util.Set;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataTipoPublicacion;
import utils.Fabrica;
import logica_Manejadores.ManejadorPaquetesYTiposPubli;
import logica_Manejadores.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario {
	
	private static ControladorUsuario instancia;
	
	private ControladorUsuario() {}
	
	public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

	@Override
	public Set<DataEmpresa> getDataEmpresa() {
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorUsuario mu = fabrica.getManejadorUsuario();
		
		Set<DataEmpresa> res = mu.getDataEmpresas();
		return res;
	}

	@Override
	public Set<DataTipoPublicacion> getDataTipoPublicacion() {
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorPaquetesYTiposPubli mu = fabrica.getManejadorPaquetesYTiposPubli();
		
		Set<DataTipoPublicacion> res = mu.getDataTipoPublicacion();
		return res;
	}
	
}
