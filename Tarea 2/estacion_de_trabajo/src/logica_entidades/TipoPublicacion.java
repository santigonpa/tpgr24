package logica_entidades;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataTipoPublicacion;

@XmlAccessorType(XmlAccessType.FIELD)

public class TipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion; 
	private int exposicion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	
	//Constructor
	
	public TipoPublicacion(String nomb, String desc, int expo, int dura, float cost, LocalDate fecha) {
		this.nombre = nomb;
		this.descripcion = desc;
		this.exposicion = expo;
		this.duracion = dura;
		this.costo = cost;
		this.fecha = fecha;

	}
	
	//getters
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public int getExposicion() {
		return exposicion;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	
	//operaciones
	
	public DataTipoPublicacion getDTTipoPublicacion() {
		DataTipoPublicacion DtTipoPub = new DataTipoPublicacion(this.nombre, this.descripcion, this.exposicion, this.duracion, this.costo, this.fecha);
		return DtTipoPub;
	}
}
