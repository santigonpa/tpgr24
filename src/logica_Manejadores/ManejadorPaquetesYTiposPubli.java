package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Paquete;
import logica_Entidades.TipoPublicacion;

public class ManejadorPaquetesYTiposPubli implements IManejadorPyT {
	
	private static ManejadorPaquetesYTiposPubli instancia;
	private Map<String,TipoPublicacion> tiposDePublicacion;
	private Map<String,Paquete> paquetes;
	
	private ManejadorPaquetesYTiposPubli() {
		this.tiposDePublicacion = new HashMap<String,TipoPublicacion>();
		this.paquetes = new HashMap<String,Paquete>();
		
	}
	
	public static ManejadorPaquetesYTiposPubli getInstance() {
		if (instancia == null)
			instancia = new ManejadorPaquetesYTiposPubli();
		
		return instancia;
	}

	public TipoPublicacion obtenerTipoPublicacion(String tipoPubli) {
		TipoPublicacion res = ((TipoPublicacion) this.tiposDePublicacion.get(tipoPubli));
		return res;
	}

	@SuppressWarnings("null")
	public Set<DataTipoPublicacion> getDataTipoPublicacion() {
		
		Set<DataTipoPublicacion> res = null;
    	Set<TipoPublicacion> temp = null;
    	
    	// Obtener las claves del Map
        Set<String> clavesTipoPublicacion = this.tiposDePublicacion.keySet();
        for(String nombreTipoPublicacion : clavesTipoPublicacion) {
        	TipoPublicacion tipoAct = ((TipoPublicacion) this.tiposDePublicacion.get(nombreTipoPublicacion));
        	temp.add(tipoAct);
        }
        for(TipoPublicacion tipoActual: temp) {
        	DataTipoPublicacion nuevaDTP = new DataTipoPublicacion(tipoActual.getNombre(),tipoActual.getDescripcion(),tipoActual.getExposicion(),tipoActual.getDuracion(),tipoActual.getCosto());
        	res.add(nuevaDTP);
        }
        
    	return res;
	}

}
