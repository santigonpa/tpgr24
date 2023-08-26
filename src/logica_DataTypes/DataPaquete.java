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
		this.setDescripcion(descripcion);
		this.setCantidadTipos(cantTipos);
		this.setValidez(validez);
		this.setDescuento(descuento);
		this.setCosto(costo);
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

	public int getCantidadTipos() {
		return cantidadTipos;
	}

	public void setCantidadTipos(int cantidadTipos) {
		this.cantidadTipos = cantidadTipos;
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
}
