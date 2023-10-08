package logica_datatypes;

import java.time.LocalDate;

public class DataPaquete {

	//Atributo
	private String nombre;
	private String descripcion;
	private int validez;
	private int descuento;
	private int costo;
	private byte[] imagen;
	private LocalDate fechadealta;
	
	public DataPaquete(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta, int costo, byte[] imagen) {
		this.nombre = nombre;
		this.setDescripcion(descripcion);
		this.setValidez(validez);
		this.setDescuento(descuento);
		this.setFechaDeAlta(fechadealta);
		this.setImagen(imagen);
		this.setCosto(costo);
	}
	
	
	public void setCosto(int costo){
		this.costo = costo;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getValidez() {
		return validez;
	}

	public void setValidez(int validez) {
		this.validez = validez;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public LocalDate getFechaDeAlta() {
		return fechadealta;
	}
	public void setFechaDeAlta(LocalDate fechadealta) {
		this.fechadealta = fechadealta;
	}

	
}
