package logica_DataTypes;

public class DataPaquete {

	//Atributo
	private String nombre;
	private String descripcion;
	private int cantidadTipos;
	private int validez;
	private int descuento;
	private float costo;
	
	public DataPaquete(String nombre, String descripcion, int cantTipos, int validez, int descuento, float costo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadTipos = cantTipos;
		this.validez = validez;
		this.descuento = descuento;
		this.costo = costo;
	}
	
	public String getNombre() {
		return nombre;
	}
}
