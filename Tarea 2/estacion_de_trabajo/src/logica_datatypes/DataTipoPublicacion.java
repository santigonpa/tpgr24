package logica_datatypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataTipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	public DataTipoPublicacion(String nomb, String desc, int exp, int dura, float costo, LocalDate fecha) {
		this.nombre = nomb;
		this.setDescripcion(desc);
		this.setExposicion(exp);
		this.setDuracion(dura);
		this.setCosto(costo);
		this.setFecha(fecha);
	}
	
	public String getNombre() {
		return nombre;
	}
	//esto es para que se muestre el nombre del TipoPublicacion en los comboBox
	public String toString() {
		return this.getNombre(); // Devuelve el nombre del TipoPublicacion
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getExposicion() {
		return exposicion;
	}

	public void setExposicion(int exposicion) {
		this.exposicion = exposicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFechaString() {
		LocalDate fechaa = this.fecha;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String fechaFormateada = fechaa.format(formatter);
	    return fechaFormateada;
	}
}
