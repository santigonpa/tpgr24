package logica_DataTypes;

public class DataTipoPublicacion {
	//Atributos
	private String nombre;
	private String descripcion;
	private int exposicion;
	private int duracion;
	private float costo;
	
	public DataTipoPublicacion(String n, String d, int e, int du, float c) {
		this.nombre = n;
		this.descripcion = d;
		this.exposicion = e;
		this.duracion = du;
		this.costo = c;
	}
	
	public String getNombre() {
		return nombre;
	}
	//esto es para que se muestre el nombre del TipoPublicacion en los comboBox
			public String toString() {
		        return this.getNombre(); // Devuelve el nombre del TipoPublicacion
		    }
}
