package logica_Entidades;

import java.util.Date;

import logica_DataTypes.DataTipoPublicacion;

public class TipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion; 
	private int exposicion;
	private int duracion;
	private float costo;
	private Date fecha;
	
	
	//Constructor
	
	public TipoPublicacion(String n, String d, int e, int du, float c, Date f) {
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
	
	public Date getFecha() {
		return fecha;
	}
	
	
	//operaciones
	
	public DataTipoPublicacion getDTTipoPublicacion() {
		DataTipoPublicacion DtTipoPub = new DataTipoPublicacion(this.nombre, this.descripcion, this.exposicion, this.duracion, this.costo, this.fecha);
		return DtTipoPub;
	}
}
