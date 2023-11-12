package logica_manejadores;

import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import logica_datatypes.DataPaquete;
import logica_datatypes.DataTipoPublicacion;
import logica_entidades.Paquete;
import logica_entidades.TipoPublicacion;

public class ManejadorPaquetesYTiposPubli implements IManejadorPyT {
	
	private static ManejadorPaquetesYTiposPubli instancia;
	private HashMap<String, TipoPublicacion> tiposDePublicacion;
	private HashMap<String, Paquete> paquetes;

	private ManejadorPaquetesYTiposPubli() {
		this.tiposDePublicacion = new HashMap<String, TipoPublicacion>();
		this.paquetes = new HashMap<String, Paquete>();
		
	}
	public static ManejadorPaquetesYTiposPubli getInstance() {
		if (instancia == null)
			instancia = new ManejadorPaquetesYTiposPubli();
		
		return instancia;
	}

	public TipoPublicacion obtenerTipoPublicacion(String tipoPubli) {
		TipoPublicacion res = (TipoPublicacion) this.tiposDePublicacion.get(tipoPubli);
		return res;
	}
	

	public ArrayList<DataTipoPublicacion> getDataTipoPublicacion() {
		
		ArrayList<DataTipoPublicacion> res = new ArrayList<>();
		ArrayList<TipoPublicacion> temp = new ArrayList<>();
    	
    	// Obtener las claves del Map
		ArrayList<String> clavesTipoPublicacion = new ArrayList<>(this.tiposDePublicacion.keySet());
        for (String nombreTipoPublicacion : clavesTipoPublicacion) {
        	TipoPublicacion tipoAct = (TipoPublicacion) this.tiposDePublicacion.get(nombreTipoPublicacion);
        	temp.add(tipoAct);
        }
        for (TipoPublicacion tipoActual: temp) {
        	DataTipoPublicacion nuevaDTP = new DataTipoPublicacion();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = tipoActual.getFecha().format(formatter);
        	nuevaDTP.setCosto(tipoActual.getCosto());
        	nuevaDTP.setDescripcion(tipoActual.getDescripcion());
        	nuevaDTP.setDuracion(tipoActual.getDuracion());
        	nuevaDTP.setExposicion(tipoActual.getExposicion());
        	nuevaDTP.setFecha(formattedDate);
        	nuevaDTP.setNombres(tipoActual.getNombre());
     ;
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
		if (paquetito == null) {
			return null;
		}else {
			DataPaquete resultado = new DataPaquete();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = paquetito.getFechaDeAlta().format(formatter);
			resultado.setCosto(paquetito.getCosto());
			resultado.setDescripcion(paquetito.getDescripcion());
			resultado.setDescuento(paquetito.getDescuento());
			resultado.setFechaDeAlta(formattedDate);
			resultado.setImagen(paquetito.getImagen());
			resultado.setNombre(paquetito.getNombre());
			resultado.setValidez(paquetito.getValidez());
			return resultado;
		}
	}
	public Paquete getPaquete(String nombre) {
					return this.paquetes.get(nombre);
	}
		public ArrayList<DataPaquete> getDataPaquete() {
		
			ArrayList<DataPaquete> res = new ArrayList<>();
			ArrayList<Paquete> temp = new ArrayList<>();
    	
    	// Obtener las claves del Map
			ArrayList<String> clavesPaquete = new ArrayList<>(this.paquetes.keySet());
        for (String nombreTipoPublicacion : clavesPaquete) {
        	Paquete tipoAct = (Paquete) this.paquetes.get(nombreTipoPublicacion);
        	temp.add(tipoAct);
        }
        for (Paquete paquetito: temp) {
        			DataPaquete nuevaDTP = new DataPaquete();
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	        String formattedDate = paquetito.getFechaDeAlta().format(formatter);
        			nuevaDTP.setCosto(paquetito.getCosto());
        			nuevaDTP.setDescripcion(paquetito.getDescripcion());
        			nuevaDTP.setDescuento(paquetito.getDescuento());
        			nuevaDTP.setFechaDeAlta(formattedDate);
        			nuevaDTP.setImagen(paquetito.getImagen());
        			nuevaDTP.setNombre(paquetito.getNombre());
        			nuevaDTP.setValidez(paquetito.getValidez());
        			res.add(nuevaDTP); 
        }
        
    	return res;
	}
	
	public void addTipoPublicacion(TipoPublicacion tipo) {
		String nombre = tipo.getNombre();
		this.tiposDePublicacion.put(nombre, tipo);
	}
	
	public boolean tipoPubliYaExiste(String nombre) {
		return tiposDePublicacion.containsKey(nombre);
	}
	public boolean nombrePaqueteYaExiste(String nombre) {
		return paquetes.containsKey(nombre);
	}
}
