package logica_DataTypes;

import java.util.Date;

public class DataTipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	private Date fecha;
	
	public DataTipoPublicacion(String n, String d, int e, int du, float c, Date f) {
		this.nombre = n;
		this.descripcion = d;
		this.exposicion = e;
		this.duracion = du;
		this.costo = c;
		this.fecha = f;
	}
	
	public String getNombre() {
		return nombre;
	}
	//esto es para que se muestre el nombre del TipoPublicacion en los comboBox
			public String toString() {
		        return this.getNombre(); // Devuelve el nombre del TipoPublicacion
		    }
}
