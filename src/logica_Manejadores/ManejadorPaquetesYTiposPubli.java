package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;

import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Paquete;
import logica_Entidades.TipoPublicacion;

public class ManejadorPaquetesYTiposPubli {
	
	private static ManejadorPaquetesYTiposPubli instancia;
	private Map<String,TipoPublicacion> tiposDePublicion;
	private Map<String,Paquete> paquetes;
	
	private ManejadorPaquetesYTiposPubli() {
		this.tiposDePublicion = new HashMap<String,TipoPublicacion>();
		this.paquetes = new HashMap<String,Paquete>();
		
	}
	
	public static ManejadorPaquetesYTiposPubli getInstance() {
		if (instancia == null)
			instancia = new ManejadorPaquetesYTiposPubli();
		
		return instancia;
	}

	public TipoPublicacion obtenerTipoPublicacion(String tipoPubli) {
		TipoPublicacion res = ((TipoPublicacion) this.tiposDePublicion.get(tipoPubli));
		return res;
	}

}
