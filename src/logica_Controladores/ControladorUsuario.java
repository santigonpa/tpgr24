package logica_Controladores;

import java.util.Set;

import logica_DataTypes.DataEmpresa;
import utils.Fabrica;
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
		
	
	
}
