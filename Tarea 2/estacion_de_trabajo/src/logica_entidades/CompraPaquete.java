package logica_entidades;


import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataCompraPaquete;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)

public class CompraPaquete {
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	private Paquete paqCompr;
	private ArrayList<TipoPublicacion> tipoPublicaciones;
		
	public CompraPaquete() {
	}
	
	//setters
	
	
	public void setFechaCompr(LocalDate fecha) {
		this.fechaCompra = fecha;
	}
	
	public void setFechaVenc(LocalDate fecha) {
		this.fechaVenc = fecha;
	}
	
	public void setPaquete(Paquete paq) {
		this.paqCompr = paq;
		ArrayList<TipoPublicacion> tipospu = paq.getTipoPublicacions();
		this.tipoPublicaciones = tipospu;
	}
	
	public void setTipoPubli(ArrayList<TipoPublicacion> tipospu) {
		this.tipoPublicaciones = tipospu;
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
	
	public DataCompraPaquete getDTCompraPaquete() {
		DataCompraPaquete DtCompraPaq = new DataCompraPaquete();
		DtCompraPaq.setFechaCompra(this.fechaCompra);
		DtCompraPaq.setFechaVenc(this.getFechaVencimiento());
		return DtCompraPaq;
	}

	public int getCosto() {
		return paqCompr.getCosto();
	}
	
	//operaciones 
	
	public boolean existeTipoPubli(String nombreTipo) {
		return this.paqCompr.existeTipoPubli(nombreTipo);
	}
	
	public int cantTipoPubli() {
		return this.tipoPublicaciones.size();
	}
	
	public boolean yaSeUsoTipoPubli(String nombreTipo) {
		for (TipoPublicacion publi : this.tipoPublicaciones) {
			if (nombreTipo.equals(publi.getNombre())) {
				tipoPublicaciones.remove(publi);
				return true;
			}
		}
		return false;
	}


}
