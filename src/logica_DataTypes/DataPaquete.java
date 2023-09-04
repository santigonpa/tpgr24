package logica_DataTypes;

import java.time.LocalDate;

public class DataPaquete {

	//Atributo
	private String nombre;
	private String descripcion;
	private int validez;
	private int descuento;
	private LocalDate fechadealta;
	
	public DataPaquete(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta) {
		this.nombre = nombre;
		this.setDescripcion(descripcion);
		this.setValidez(validez);
		this.setDescuento(descuento);
		this.setFechaDeAlta(fechadealta);
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
