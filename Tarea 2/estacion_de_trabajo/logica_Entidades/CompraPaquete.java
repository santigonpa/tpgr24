package logica_Entidades;

import java.time.*;
import java.util.Map;
import java.util.HashMap;

import logica_DataTypes.DataCompraPaquete;

public class CompraPaquete {
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	private Paquete paqCompr;
	private Map<String, TipoPublicacion> tipoPublicaciones;
	
	//constructor
	public CompraPaquete(LocalDate fechaCom, LocalDate fechaVen) {
		this.fechaCompra = fechaCom;
		this.fechaVenc = fechaVen;
		this.paqCompr = null;
		this.tipoPublicaciones = new HashMap<>();
	}
	
	//getters
	
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	
	public LocalDate getFechaVencimiento() {
		return fechaVenc;
	}
	
	public Paquete getPaquete() {
		return paqCompr;
	}
	
	public Map<String, TipoPublicacion> getTipoDePublicacionesDisp(){
		return tipoPublicaciones;
	}
	
	public TipoPublicacion getTipoPubli(String nombreTipo) {
		return this.tipoPublicaciones.get(nombreTipo);
	}
	
	//operaciones 
	
	public boolean existeTipoPubli(String nombreTipo) {
		return this.tipoPublicaciones.containsKey(nombreTipo);
	}
	
	public int cantTipoPubli() {
		return this.tipoPublicaciones.size();
	}
	
	public void yaSeUsoTipoPubli(String nombreTipo) {
		this.tipoPublicaciones.remove(nombreTipo);
	}

	public DataCompraPaquete getDTCompraPaquete() {
		DataCompraPaquete DtCompraPaq = new DataCompraPaquete(this.fechaCompra, this.fechaVenc);
		return DtCompraPaq;
	}

	public int getCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
}
