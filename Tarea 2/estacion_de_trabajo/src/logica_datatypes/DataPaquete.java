package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DataPaquete {

	//Atributo
	private String nombre;
	private String descripcion;
	private int validez;
	private int descuento;
	private int costo;
	private byte[] imagen;
	private String fechadealta;
	
	public DataPaquete() {

	}
	
	//setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCosto(int costo){
		this.costo = costo;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public void setFechaDeAlta(String fechadealta) {
		this.fechadealta = fechadealta;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setValidez(int validez) {
		this.validez = validez;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	//getters
	
	public int getCosto(){
		return this.costo;
	}
	
	public byte[] getImagen() {
		return this.imagen;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getValidez() {
		return validez;
	}

	public int getDescuento() {
		return descuento;
	}
	public String getFechaDeAlta() {
		return fechadealta;
	}
	
	//esto es para que se muestre el nombre de la empresa en los comboBox
	public String toString() {
		return this.getNombre(); // Devuelve el nombre del paquete
	}

	
}
