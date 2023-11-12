package logica_entidades;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataPaquete;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	public Paquete() {
		super();
	}
	
	//setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	} 
	
	public void setValidez(int val) {
		this.validez = val;
	}
	
	public void setDescuento(int desc) {
		this.descuento = desc;
	}
	
	public void setFechaAlta(LocalDate fecha) {
		this.fechadealta = fecha;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public void setTipoPublicaciones(ArrayList<TipoPublicacion> tipos) {
		this.tipoPublicaciones = tipos;
	}
	
	public void setPublicaciones(TipoPublicacion publi, int cantidad) {
		if (this.tipoPublicaciones == null) {
			this.tipoPublicaciones = new ArrayList<TipoPublicacion>();
		}
		for (int i=1; i <= cantidad ; i++) {
			(this.tipoPublicaciones).add(publi);			
		}
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
			if (tipo.getNombre() .equals(tipoP)) {
				return tipo;
			}
		}
		return null;
	}
	
	public boolean existeTipoPubli(String tipoP) {
		for (TipoPublicacion tipo : this.tipoPublicaciones) {
			if (tipo.getNombre() .equals(tipoP)) {
				return true;
			}
		}
		return false;
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
		DataPaquete DtPaq = new DataPaquete();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = this.fechadealta.format(formatter);
		DtPaq.setCosto(this.costo);
		DtPaq.setDescripcion(this.descripcion);
		DtPaq.setDescuento(this.descuento);
		DtPaq.setFechaDeAlta(formattedDate);
		DtPaq.setImagen(this.imagen);
		DtPaq.setValidez(this.validez);
		DtPaq.setNombre(this.nombre);
		return DtPaq;
	}

}
