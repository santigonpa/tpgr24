package logica_datatypes;

import java.time.LocalDate;

public class DataPostulacion extends DataUsuario {

	//Atributos
	private LocalDate fecha;
	private String curri;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion() {
	
	}

	//setters

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setCv(String curri) {
		this.curri = curri;
	}

	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}


	public void setNickPostulante(String nickPostulante) {
		this.nickPostulante = nickPostulante;
	}
	
	//getters
	
	public LocalDate getFecha() {
		return fecha;
	}


	public String getCv() {
		return curri;
	}

	public String getMotivacion() {
		return motivacion;
	}


	public String getNickPostulante() {
		return nickPostulante;
	}


	
	
}
