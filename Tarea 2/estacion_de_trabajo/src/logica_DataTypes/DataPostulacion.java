package logica_DataTypes;

import java.time.*;

public class DataPostulacion extends DataUsuario {

	//Atributos
	private LocalDate fecha;
	private String cv;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion(LocalDate fecha2, String cv, String m, String nickPost) {
		this.setFecha(fecha2);
		this.setCv(cv);
		this.setMotivacion(m);
		this.setNickPostulante(nickPost);
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getMotivacion() {
		return motivacion;
	}


	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}


	public String getNickPostulante() {
		return nickPostulante;
	}


	public void setNickPostulante(String nickPostulante) {
		this.nickPostulante = nickPostulante;
	}
	
	
	
}
