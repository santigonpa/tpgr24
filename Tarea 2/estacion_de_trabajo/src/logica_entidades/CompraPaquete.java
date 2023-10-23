package logica_entidades;


import java.util.ArrayList;

import logica_datatypes.DataCompraPaquete;

import java.time.LocalDate;

public class CompraPaquete {
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	private Paquete paqCompr;
	private ArrayList<TipoPublicacion> tipoPublicaciones;
		
	public CompraPaquete(int costo, LocalDate fechaVen, LocalDate fechaCom, Paquete paqCompr) {
		this.fechaCompra = fechaCom;
		this.fechaVenc = fechaVen;
		this.tipoPublicaciones = paqCompr.getTipoPublicacions();
		this.paqCompr = paqCompr;
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
	
	public ArrayList<TipoPublicacion> getTipoDePublicacionesDisp(){
		return tipoPublicaciones;
	}
	
	public TipoPublicacion getTipoPubli(String nombreTipo) {
		return this.paqCompr.getTipoPubli(nombreTipo);
	}
	
	//operaciones 
	
	public boolean existeTipoPubli(String nombreTipo) {
		return this.paqCompr.ExisteTipoPubli(nombreTipo);
	}
	
	public int cantTipoPubli() {
		return this.tipoPublicaciones.size();
	}
	
	public boolean yaSeUsoTipoPubli(String nombreTipo) {
		for (TipoPublicacion publi : this.tipoPublicaciones) {
			if (nombreTipo .equals(publi.getNombre())) {
				tipoPublicaciones.remove(publi);
				return true;
			}
		}
		return false;
	}

	public DataCompraPaquete getDTCompraPaquete() {
		DataCompraPaquete DtCompraPaq = new DataCompraPaquete(this.fechaCompra, this.fechaVenc);
		return DtCompraPaq;
	}

	public int getCosto() {
		return paqCompr.getCosto();
	}
}
