package logica_Entidades;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

import logica_DataTypes.DataPaquete;

public class Paquete {

	//Atributos
	private String nombre;
	private String descripcion;
	private int validez;
	private int descuento;
	private LocalDate fechadealta;
	private Map<String, TipoPublicacion> tipoPublicaciones;
	
	
	//Contructor
	//solo llamar si el descuento esta entre 0 y 100
	public Paquete(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.fechadealta = fechadealta;
		this.tipoPublicaciones = new HashMap<>();
	}
	
	//getters
	

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public LocalDate getFechaDeAlta() {
		return fechadealta;
	}
	
	public int getValidez() {
		return validez;
	}
	
	public int getDescuento() {
		return descuento;
	}
	
	public Map<String, TipoPublicacion> getTipoPublicacions(){
		return tipoPublicaciones;
	}
	
	public TipoPublicacion getTipoPubli(String tipoP) {
		return this.tipoPublicaciones.get(tipoP);
	}
	
	//setters
	
	/*public void setCantidadTipos(int cant) {
		this.cantidadDeTipos = cant;
	}
	
	//operaciones
	//Si agrego un solo tipo el int no seria siempre 1?? 
	//necesitaria la instancia, deberia ser ingresada en la funcion
	public void agregarTipoDePublicacionAPQ(int cant, String nombreTipoPubli) {
		this.cantidadDeTipos = this.cantidadDeTipos + cant;
		
	}
	*/
	public DataPaquete getDTPaquete() {
		DataPaquete DtPaq = new DataPaquete(this.nombre, this.descripcion, this.validez, this.descuento, this.fechadealta);
		return DtPaq;
	}

}
