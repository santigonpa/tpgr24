package logica_Manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import logica_DataTypes.DataPaquete;
import logica_DataTypes.DataTipoPublicacion;
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

	public Set<DataTipoPublicacion> getDataTipoPublicacion() {
		
		Set<DataTipoPublicacion> res = new HashSet<>();
    	Set<TipoPublicacion> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesTipoPublicacion = this.tiposDePublicacion.keySet();
        for(String nombreTipoPublicacion : clavesTipoPublicacion) {
        	TipoPublicacion tipoAct = ((TipoPublicacion) this.tiposDePublicacion.get(nombreTipoPublicacion));
        	temp.add(tipoAct);
        }
        for(TipoPublicacion tipoActual: temp) {
        	DataTipoPublicacion nuevaDTP = new DataTipoPublicacion(tipoActual.getNombre(),tipoActual.getDescripcion(),tipoActual.getExposicion(),tipoActual.getDuracion(),tipoActual.getCosto(),tipoActual.getFecha());
        	res.add(nuevaDTP);
        }
        
    	return res;
	}
	
	public void addPaquete(Paquete paq) {
		String nombre = paq.getNombre();
		this.paquetes.put(nombre, paq);
	}
	
	public DataPaquete getDataPaquete(String nombre) {
		Paquete paquetito = this.paquetes.get(nombre);
		if(paquetito == null) {
			return null;
		}else {
			DataPaquete resultado = new DataPaquete(paquetito.getNombre(), paquetito.getDescripcion(), paquetito.getValidez(), paquetito.getDescuento(), paquetito.getFechaDeAlta(), paquetito.getCosto(), paquetito.getImagen());
			return resultado;
		}
	}
	
		public Set<DataPaquete> getDataPaquete() {
		
		Set<DataPaquete> res = new HashSet<>();
    	Set<Paquete> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesPaquete = this.paquetes.keySet();
        for(String nombreTipoPublicacion : clavesPaquete) {
        	Paquete tipoAct = ((Paquete) this.paquetes.get(nombreTipoPublicacion));
        	temp.add(tipoAct);
        }
        for(Paquete paquetito: temp) {
        	DataPaquete nuevaDTP = new DataPaquete(paquetito.getNombre(), paquetito.getDescripcion(), paquetito.getValidez(), paquetito.getDescuento(), paquetito.getFechaDeAlta(), paquetito.getCosto(), paquetito.getImagen());
        	res.add(nuevaDTP);
        }
        
    	return res;
	}
	
	public void addTipoPublicacion(TipoPublicacion tp) {
		String nombre = tp.getNombre();
		this.tiposDePublicacion.put(nombre, tp);
	}
	
	public boolean TipoPubliYaExiste(String nombre) {
		return tiposDePublicacion.containsKey(nombre);
	}
	public boolean NombrePaqueteYaExiste(String nombre) {
		return paquetes.containsKey(nombre);
	}
}
