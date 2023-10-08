package logica_datatypes;

import java.time.LocalDate;

public class DataPostulacion extends DataUsuario {

	//Atributos
	private LocalDate fecha;
	private String curri;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion(LocalDate fecha2, String curri, String motiv, String nickPost) {
		this.setFecha(fecha2);
		this.setCv(curri);
		this.setMotivacion(motiv);
		this.setNickPostulante(nickPost);
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCv() {
		return curri;
	}


	public void setCv(String curri) {
		this.curri = curri;
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
