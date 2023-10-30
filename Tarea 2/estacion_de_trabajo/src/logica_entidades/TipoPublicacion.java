package logica_entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public TipoPublicacion() {

	}
	
	//setters
	
	public void setNombre(String nomb) {
		this.nombre = nomb;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void setDuracion(int dura) {
		this.duracion = dura;
	}
	
	public void setExposicion(int expo) {
		this.exposicion = expo;
	}
	
	public void setCosto( float cost) {
		this.costo = cost;
	}
	
	public void setFecha(LocalDate fecha) {
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
		DataTipoPublicacion DtTipoPub = new DataTipoPublicacion();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = this.fecha.format(formatter);
		DtTipoPub.setCosto(this.costo);
		DtTipoPub.setDescripcion(this.descripcion);
		DtTipoPub.setDuracion(this.duracion);
		DtTipoPub.setExposicion(this.exposicion);
		DtTipoPub.setFecha(formattedDate);
		DtTipoPub.setNombres(this.nombre);
		return DtTipoPub;
	}
}
