package logica_entidades;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataPaquete;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)

public class Paquete {

	//Atributos
	private String nombre;
	private String descripcion;
	private int validez;
	private int descuento;
	private int costo; //nuevo para la tarea2
	private LocalDate fechadealta;
	private ArrayList<TipoPublicacion> tipoPublicaciones;
	private byte[] imagen; // Nuevo atributo para la imagen del paquete
	
	//Contructor
	//solo llamar si el descuento esta entre 0 y 100
	public Paquete(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta, int costo, byte[] imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.fechadealta = fechadealta;
		this.costo = costo;
		this.imagen = imagen;
		this.tipoPublicaciones = new ArrayList<>();
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
	
	public int getCosto() {
		return costo;
	}
	
	public byte[] getImagen() {
		return imagen;
	}
	
	public ArrayList<TipoPublicacion> getTipoPublicacions(){
		return tipoPublicaciones;
	}
	
	public TipoPublicacion getTipoPubli(String tipoP) {
		for (TipoPublicacion tipo : this.tipoPublicaciones) {
			if(tipo.getNombre() .equals(tipoP)) {
				return tipo;
			}
		}
		return null;
	}
	
	public boolean ExisteTipoPubli(String tipoP) {
		for (TipoPublicacion tipo : this.tipoPublicaciones) {
			if(tipo.getNombre() .equals(tipoP)) {
				return true;
			}
		}
		return false;
	}
	
	public void setPublicaciones(TipoPublicacion publi, int cantidad) {
		(this.tipoPublicaciones).add(publi);
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
		DataPaquete DtPaq = new DataPaquete(this.nombre, this.descripcion, this.validez, this.descuento, this.fechadealta, this.costo, this.imagen);
		return DtPaq;
	}

}
