package logica_Entidades;

import logica_DataTypes.DataTipoPublicacion;

public class TipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion; 
	private int exposicion;
	private int duracion;
	private float costo;
	
	
	//Constructor
	
	public TipoPublicacion(String n, String d, int e, int du, float c) {
		this.nombre = n;
		this.descripcion = d;
		this.exposicion = e;
		this.duracion = du;
		this.costo = c;

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
	
	
	//operaciones
	
	public DataTipoPublicacion getDTTipoPublicacion() {
		DataTipoPublicacion DtTipoPub = new DataTipoPublicacion(this.nombre, this.descripcion, this.exposicion, this.duracion, this.costo);
		return DtTipoPub;
	}
}
