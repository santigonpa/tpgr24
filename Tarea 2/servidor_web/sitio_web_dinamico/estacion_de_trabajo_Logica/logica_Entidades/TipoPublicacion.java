package logica_Entidades;

import java.time.LocalDate;
import logica_DataTypes.DataTipoPublicacion;

public class TipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion; 
	private int exposicion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	
	//Constructor
	
	public TipoPublicacion(String n, String d, int e, int du, float c, LocalDate f) {
		this.nombre = n;
		this.descripcion = d;
		this.exposicion = e;
		this.duracion = du;
		this.costo = c;
		this.fecha = f;

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
