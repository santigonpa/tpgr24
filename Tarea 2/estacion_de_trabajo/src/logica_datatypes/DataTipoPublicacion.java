package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataTipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private String fecha;
	
	public DataTipoPublicacion() {

	}
	
	//setters

	public void setNombres(String nombre) {
		this.nombre = nombre;
	}
	

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public void setExposicion(int exposicion) {
		this.exposicion = exposicion;
	}


	//gettes
	
	public String getNombre() {
		return nombre;
	}
	//esto es para que se muestre el nombre del TipoPublicacion en los comboBox
	public String toString() {
		return this.getNombre(); // Devuelve el nombre del TipoPublicacion
	}

	public String getFecha() {
		return fecha;
	}
	public float getCosto() {
		return costo;
	}
	public int getDuracion() {
		return duracion;
	}
	public int getExposicion() {
		return exposicion;
	}
	public String getDescripcion() {
		return descripcion;
	}

}
